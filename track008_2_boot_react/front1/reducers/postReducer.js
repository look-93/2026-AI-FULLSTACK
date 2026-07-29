import { createSlice } from "@reduxjs/toolkit";

//1. 초기화 상태
const initialState = { //컨트롤러 리턴값확인
    posts:[],   // 전체 게시글
    currentPost: null, // 단건 게시글
    
    loading:false,
    error:null,
    success:false
};

const postReducer = createSlice({
    name:"post",
    initialState,
    reducers: {
        //... 전체게시글 ...
        fetchPostsRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;         
        },
        fetchPostsSuccess : (state, action)=>{
            state.loading = false;
            state.posts = action.payload;
            state.success = true; 
        },
        fetchPostsFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.success = false;          
        },

        //... 단건게시글 ...
        fetchPostDetailRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;           
        },
        fetchPostDetailSuccess : (state, action)=>{
            state.loading = false;
            state.currentPost = action.payload;
            state.success = true;             
        },
        fetchPostDetailFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.success = false;               
        },

        //... 게시글작성 ...
        createPostRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;              
        },
        createPostSuccess : (state, action)=>{
            state.loading = false;
            state.posts = [action.payload, ...state.posts]; //새글을 목록상단추가
            state.success = true;   
        },
        createPostFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.success = false;             
        },

        //... 게시글수정 ...
        updatePostRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;              
        },
        updatePostSuccess : (state, action)=>{
            state.loading = false;
            state.posts = state.posts.map(post => post.id === action.payload.id ? action.payload : post)
            state.currentPost = action.payload;
            state.success = true;             
        },
        updatePostFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.success = false;              
        },

        //... 게시글삭제 ...
        deletePostRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;  
        },
        deletePostSuccess : (state, action)=>{
            state.loading = false;
            //state.posts = state.posts.map(post => post.id !== action.payload)//서버에서 몇번째글 삭제했는지 id값 줌
            state.posts = state.posts.filter(post => post.id !== action.payload);
            state.success = true;       
        },
        deletePostFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.success = false;    
        },

        //... 상태 초기화 ...
        resetPostState : (state)=>{
            state.loading = false;
            state.error = null;
            state.success = false;
        },

        //... 페이징 .... 나중에....
    }
});

export const {
    fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
    fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
    createPostRequest, createPostSuccess, createPostFailure,
    updatePostRequest, updatePostSuccess, updatePostFailure,
    deletePostRequest, deletePostSuccess, deletePostFailure,
    resetPostState
} =  postReducer.actions;

export default postReducer.reducer;