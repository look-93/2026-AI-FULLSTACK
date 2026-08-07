// components/EditPostModal
import {Modal , Form , Input , Button, Select, Upload}  from 'antd';
import { UploadOutlined, UpOutlined } from "@ant-design/icons"; 
import { useEffect, useState  } from 'react';

export default function   EditPostModal({
    visible, onCancel,  editPost, onSubmit, uploadFiles, setUploadFiles
}){ 
    
    //해시태그가 계속 살아있는 문제 해결, Form 인스턴스 재사용 + initialValues 문제
    const [form] = Form.useForm();
    useEffect(()=>{
    if(editPost){
        form.setFieldsValue({
            content: editPost.content,
            hashtags: editPost.hashtags
        });
// ✅ 기존 이미지 → antd Upload fileList 형식으로 변환
        const existingImages = (editPost.imageUrls).map((img, idx) => ({
            uid: `existing-${img.id ?? idx}`,   // 기존 이미지 구분용 uid
            name: img.originalName || `image-${idx}`,
            status: 'done',
            url: img.url || img.src,            // 실제 이미지 접근 URL
            // 서버에서 지우거나 새 파일과 구분할 때 쓰려면 원본 정보도 보관
            isExisting: true,
            imageId: img.id,
        }));

        setUploadFiles(existingImages);
    }
    },[editPost, form]);

    return(<Modal  title="글 수정"   open={visible}      
        onCancel={()=>{
        form.resetFields();
        setUploadFiles([]);
        onCancel();
    }}  footer={null}  >
        <Form  
            // initialValues={{ 
            //     content:editPost?.content, 
            //     hashtags:editPost?.hashtags
            // }}
            form={form}
            onFinish={onSubmit}
            layout="vertical"
        >
            <Form.Item  name="content"  label="내용">
                <Input.TextArea  rows={4}/>
            </Form.Item>

            <Form.Item 
                label="해시태그"
                name="hashtags"
            >
                <Select mode="tags" style={{width:"100%"}} placeholder="해시태그 입력 후 Enter" />
            </Form.Item>

            <Form.Item label="이미지업로드">
                <Upload 
                    multiple 
                    beforeUpload={()=>false} 
                    fileList={uploadFiles}
                    onChange={({fileList})=>setUploadFiles(fileList)}
                    listType="picture-card"
                >
                    <UploadOutlined />
                    <div>이미지 선택</div>
                </Upload>
            </Form.Item>

            <Button  type="primary"  htmlType="submit">
                수정완료
            </Button>
        </Form>
    </Modal>);
}
{/* initialValues 초기값 셋팅 */}