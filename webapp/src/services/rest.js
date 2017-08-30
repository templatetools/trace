import { request, config } from 'utils'

const { api } = config
const { user } = api

export async function query (params) {
  return request({
    url: '/rest/api/v1/' + params.modalName + '/page',
    method: 'post',
    data: params.data,
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
