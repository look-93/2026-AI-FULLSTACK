import { call, put } from 'redux-saga/effects';
import axios from 'axios';
import {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState
} from '../../reducers/postReducer';
import { fetchPosts, fetchPostDetail, createPost, updatePost, deletePost} from '../postSaga';

jest.mock('axios');

describe('post saga', ()=>{
    afterEach(()=>{jest.clearAllMocks()});

    //전체 게시글 조회
    it('fetchPosts', ()=>{
        const generator = fetchPosts(fetchPostsRequest());
        expect(generator.next().value.type).toBe('CALL');

        const mockData = [{id:1, content: 'pist 1'}];
        const putStep = generator.next({data:mockData}).value;

        expect(putStep).toEqual(put(fetchPostsSuccess(mockData)));
    }); 
    
    it('fetchPostDetail success', () => {
        const generator = fetchPostDetail(fetchPostDetailRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 1, content: 'detail' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
    });
 
 
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });
 
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });
 
    it('deletePost success', () => {
        const generator = deletePost(deletePostRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next().value;
        
        expect(putStep).toEqual(put(deletePostSuccess(1)));
    });
})