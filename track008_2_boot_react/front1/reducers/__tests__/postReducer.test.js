import { current } from 'immer';
import postReducer, {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState   
} from '../postReducer'

describe('post slice reducer', ()=>{
    const initialState = { //컨트롤러 리턴값확인
        posts:[],   // 전체 게시글
        currentPost: null, // 단건 게시글    
        loading:false,
        error:null,
        success:false
    };

    it('fetchPostsRequest & fetchPostsSuccess', ()=>{
        const requestState  = postReducer(initialState, fetchPostsRequest());
        expect(requestState.loading).toBe(true);
        expect(requestState.error).toBe(null);
        expect(requestState.success).toBe(false);

        const posts = [{id:1, content: '첫번째글'}];
        const successState  = postReducer(initialState, fetchPostsSuccess(posts));
        expect(successState.loading).toBe(false);
        expect(successState.posts).toEqual(posts);
        expect(successState.success).toBe(true);
    });

    it('fetchPostDetailRequest & fetchPostDetailSuccess',()=>{
        let state = postReducer(initialState, fetchPostDetailRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);

        const post = {id:1, content:'두번째글'};
        state = postReducer(initialState, fetchPostDetailSuccess(post));
        expect(state.loading).toBe(false);
        expect(state.currentPost).toEqual(post);
        expect(state.success).toBe(true);
    });

    it('createPostRequest & createPostSuccess', ()=>{
        let state = postReducer(initialState, createPostRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);

        const newPost = {id:1, content:'새 글'};
        state = postReducer(initialState, createPostSuccess(newPost));
        expect(state.loading).toBe(false);
        expect(state.posts[0]).toEqual(newPost);
        expect(state.success).toBe(true);
    });

    it('updatePostRequest & updatePostSuccess', ()=>{
        
        const updatePost = {id:1, content:'업데이트테스트'};
        const prevState = {
            ...initialState, posts: [{id:1, content:'테스트'}],
        }

        let state = postReducer(prevState, updatePostRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);

        state = postReducer(state, updatePostSuccess(updatePost));
        expect(state.loading).toBe(false);
        expect(state.posts[0].content).toBe('업데이트테스트');
        expect(state.currentPost).toEqual(updatePost);
        expect(state.success).toBe(true);
    });

    it('deletePostRequest & deletePostSuccess', ()=>{
        const prevState = {...initialState, posts:[{id:1, content:'테스트글'}]};

        let state = postReducer(initialState, deletePostRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);

        state = postReducer(initialState, deletePostSuccess(1));
        expect(state.loading).toBe(false);
        expect(state.posts).toHaveLength(0);
        expect(state.success).toBe(true);
    });

    it('resetPostState', ()=>{
        const prev = {posts:[{id:1, content:'첫번째글'}], currentPost:{id:2, content:'두번째글'},loading:true, error:'err', success:true}
        const state = postReducer(prev, resetPostState());
        expect(state.loading).toBe(false);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);
        
    });
});