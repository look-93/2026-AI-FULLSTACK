// pages/index.js
import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";
import { useRouter } from "next/router";
import { fetchPostsRequest } from '../reducers/postReducer';
import { Card, Button, Spin } from "antd";

export default function Home(){
    const dispatch = useDispatch();
    const router = useRouter();
    //1. 유저 정보 가져오기 - state.user
    const { user } = useSelector((state) => state.auth);
    //2. 게시글 정보 가져오기 - state.post    
    const {posts, loading, error} = useSelector((state) => state.post);

    //페이지가 처음 뜰 때, 조회 액션 - dispatch
    useEffect(()=>{
        dispatch(fetchPostsRequest());
    },[dispatch]);

    return (<div>
        {/*게시판리스트*/}
        <h3>게시글 : {posts.length}</h3>
        {posts.map((post, index)=>(
            <Card key={post.id || index} style={{marginBottom:"10px"}}>
                <p>{post.content}</p>
            </Card>            
        ))}
    </div>);
}
{/* 수정 부품 */}