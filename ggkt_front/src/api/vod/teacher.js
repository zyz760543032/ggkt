import request from '@/utils/request'

const api_name = '/admin/vod/teacher'

export default {
    // 讲师所有查询
    list () {
        return request({
            url: `${api_name}/findAll`,
            method: 'get'
        })
    },
    // 讲师分页查询
    pageList (currentPage, pageSize, condition) {
        return request({
            url: `${api_name}/findQueryPage/${currentPage}/${pageSize}`,
            method: 'post',
            // json格式请求体为：data+冒号+数据
            data: condition
        })
    },
    // 讲师删除
    removeById (id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: 'delete'
        })
    },
    // 讲师添加
    save (teacher) {
        return request({
            url: `${api_name}/saveTeacher`,
            method: 'post',
            data: teacher
        })
    },
    //按id查询
    getById (id) {
        return request({
            url: `${api_name}/getTeacher/${id}`,
            method: 'get'
        })
    },
    //按id修改
    updateById (teacher) {
        return request({
            url: `${api_name}/updateTeacher`,
            method: 'put',
            data: teacher
        })
    },
    //批量删除
    batchRemove (idList) {
        return request({
            url: `${api_name}/removeBatch`,
            method: `delete`,
            data: idList
        })
    },

}
