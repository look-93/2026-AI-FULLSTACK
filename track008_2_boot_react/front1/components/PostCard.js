import { Card } from "antd";

export default function PostCard(){
    return (<>
        <Card key={post.id || index} style={{marginBottom:"10px"}}>
            <p>{post.content}</p>
        </Card>         
    </>);
}