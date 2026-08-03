import { Modal, Form, TextArea, Input, Button } from "antd";
export default function EditPostModal({visible, onCancel, editPost, onSubmit}){
    return (<Modal title="글 수정" open={visible} onCancel={onCancel} footer={null}> 
        <Form layout="vertical" onFinish={(values)=>{onSubmit(editPost.id, values)}}  initialValues={{content:editPost?.content,}}>
            <Form.Item name="content" label="내용">
                <Input.TextArea rows={4}/>            
            </Form.Item>
            <Button type="primary" htmlType="submit">수정완료</Button>
        </Form>
    </Modal>);
}

{/*  footer={null} : cansel/ ok 빠짐 onCancel={onCalcel}: x 눌렀을때 닫기*/}