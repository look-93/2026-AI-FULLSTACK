import {all, call, put, fork, takeLatest} from 'redux-saga/effects';
import axios from 'axios';
import {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhost:8080/api/posts';

// get /api/posts
export const fetchPostsApi = () => axios.get(POST_API_BASE);
export function* fetchPosts(){
    try{
        const result = yield call(fetchPostsApi);
        yield put(fetchPostsSuccess(result.data));

    }catch(err){
        yield put(fetchPostsFailure(err.response?.data?.message || err.message));
    }
}
function* watchFetchPosts(){
    yield takeLatest(fetchPostsRequest.type, fetchPosts);
}

// get /api/posts/{id}
export const fetchPostDetailApi = (id) => axios.get(`${POST_API_BASE}/${id}`);
export function* fetchPostDetail(action){
    try{
       const result = yield call(fetchPostDetailApi, action.payload);
       yield put(fetchPostDetailSuccess(result.data));
    }catch(err){
        yield put(fetchPostDetailFailure(err.response?.data?.message || err.message));
    }
}
function* watchFetchPostDetail(){
    yield takeLatest(fetchPostDetailRequest.type, fetchPostDetail);
}

// post /api/posts
export const createPostApi = (postData) => axios.post(POST_API_BASE, postData);
export function* createPost(action){
    try{
       const result = yield call(createPostApi, action.payload)
       yield put(createPostSuccess(result.data))       
    }catch(err){
        yield put(createPostFailure(err.response?.data?.message || err.message));
    }
}
function* watchCreatePost(){
    yield takeLatest(createPostRequest.type, createPost);
}

// put /api/posts/{id}
export const updatePostApi = (postId, dto) => axios.put(`${POST_API_BASE}/${postId}`, dto);
export function* updatePost(action){
    try{
       const result = yield call(updatePostApi, action.payload.postId, action.payload.dto)
       yield put(updatePostSuccess(result.data))
    }catch(err){
        yield put(updatePostFailure(err.response?.data?.message || err.message));
    }
}
function* watchUpdatePost(){
    yield takeLatest(updatePostRequest.type, updatePost);
}

// delete /api/posts/{id}
export const deletePostApi = (id) => axios.delete(`${POST_API_BASE}/${id}`);
export function* deletePost(action){
    try{
       yield call(deletePostApi, action.payload);
       yield put(deletePostSuccess(action.payload));
    }catch(err){
        yield put(deletePostFailure(err.response?.data?.message || err.message));
    }
}
function* watchDeletePost(){
    yield takeLatest(deletePostRequest.type, deletePost);
}

export default function* postSaga(){
    yield all([
        call(watchFetchPosts),     
        call(watchFetchPostDetail),
        call(watchCreatePost),       
        call(watchUpdatePost),
        call(watchDeletePost),          
    ]);
}