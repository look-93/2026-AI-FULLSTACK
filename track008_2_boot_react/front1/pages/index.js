// pages/index.js
import { useSelector, useDispatch } from "react-redux"; // 전역상태, 스토어알림
import { useState, useEffect } from "react";    // 변수, 이벤트 변경감지
import { useRouter } from "next/router";
import { fetchPostsRequest, updatePostRequest, deletePostRequest } from '../reducers/postReducer';
import { Spin } from "antd";
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

export default function Home(){
    const dispatch = useDispatch();
    const router = useRouter();
    //1. 유저 정보 가져오기 - state.user
    const { user } = useSelector((state) => state.auth);
    //2. 게시글 정보 가져오기 - state.post    
    const {posts, loading, error} = useSelector((state) => state.post);

    //수정모달:isEditModalVisible, setIsEditModalVisible
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    //수정할글:editPost , setEditPost
    const [editPost, setEditPost] = useState(null);
    //수정기능 : handleEditSubmit
    const handleEdit = (post) => {
        setEditPost(post); //수정글셋팅
        setIsEditModalVisible(true); // 수정화면보이기
    };

    const handleEditSubmit = (id, values) => {
        dispatch(updatePostRequest({postId: editPost?.id, dto:{content:values.content}})); // 수정기능 후
        setIsEditModalVisible(false); // 화면안보이기
        setEditPost(null);
    };

    //삭제기능 : handleDelete
    const handleDelete = (postId) => {
        dispatch(deletePostRequest(postId))
    }

    //페이지가 처음 뜰 때, 조회 액션 - dispatch
    useEffect(()=>{
        dispatch(fetchPostsRequest());
    },[dispatch]);

    return (
        <>
            <PostList posts={posts} handleEdit={handleEdit} handleDelete={handleDelete}/>
            <EditPostModal 
            visible={isEditModalVisible} 
            onCancel={()=> setIsEditModalVisible(false)} 
            editPost={editPost} 
            onSubmit={handleEditSubmit}/>
        </>
    );
}
{/* 수정 부품 */}