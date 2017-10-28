import { request, config } from 'utils'

const { api } = config
const { user } = api


export async function columns (params) {
  return request({
    url: '/rest/api/v1/' + params.modalName + '/view/list',
    method: 'get'
  })
}

export async function query (params) {
  console.log('query params', params);
  let page = {'pageNumber':params.data.pageNumber, 'pageSize':params.data.pageSize || 10}

  delete params.data.pageNumber
  delete params.data.pageSize

  let filters = [];

  for (var key in params.data){
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
    let ids = '';
    if (params.data instanceof  Array){
      ids = params.data.join(',')
    }else{
      ids = params.data;
    }
    console.log('remove', '/rest/api/v1/' + params.modalName + '/' + ids)
  return request({
    url: '/rest/api/v1/' + params.modalName + '/' + ids,
    method: 'delete'
  })
}

export async function update (params) {
  return request({
    url: '/rest/api/v1/' + params.modalName,
    method: 'post',
    data: params.data,
  })
}

export async function reference (params) {
  let filters = [];
  if (null != params.data){
    filters.push({'fieldName':'searchText', 'operator':'LIKE', 'value':params.data})
  }
  let andFilter = [];
  if (null != params.filter){
    andFilter.push(params.filter)
  }

  return request({
    url: '/rest/api/v1/' + params.modalName + '/page',
    method: 'post',
    data: {filters:filters, andFilters:andFilter, 'pageNumber':1, 'pageSize':10},
  })
}


