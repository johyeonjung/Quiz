const deleteButton = document.getElementById('delete-btn');
if(deleteButton) {
    deleteButton.addEventListener('click',event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다');
                location.replace('/articles');
            });
    });
}
//html에서 id를 delete-btn으로 설정한 엘리먼트를 찾아
// 그 엘리먼트에서 클릭 이벤트가 발생하면 fetch()메서드를 통해 /api/articles/delete
// 요청을 보내는 역할을 함

const modifyButton = document.getElementById('modify-btn');

if(modifyButton) {
    modifyButton.addEventListener('click',event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}