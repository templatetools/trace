import { request, config } from 'utils'

const { api } = config
const { user } = api

export async function query (params) {
  let page = {'pageNumber':params.data.pageNumber, 'pageSize':params.data.pageSize}

  delete params.data.pageNumber
  delete params.data.pageSize

  let filters = [];

  for (var key in params.data){
    console.log('typeof(params.data[key])', typeof(params.data[key]));
    if (params.data[key] instanceof  Array){
      params.data[key].map((item,index)=>{
        filters.push({'fieldName':key, 'operator':'LIKE', 'value':item});  
      })
    }else{
      filters.push({'fieldName':key, 'operator':'LIKE', 'value':params.data[key]});
    }
  }

  page['filters'] = filters;

  return request({
    url: '/rest/api/v1/' + params.modalName + '/page',
    method: 'post',
    data: page,
  })
}

export async function create (params) {
  return request({
    url: '/rest/api/v1/' + params.modalName,
    method: 'post',
    data: params.data,
  })
}

export async function remove (params) {
  return request({
    url: '/rest/api/v1/' + params.modalName,
    method: 'delete',
    data: params.id,
  })
}

export async function update (params) {
  return request({
    url: user,
    method: 'patch',
    data: params,
  })
}
