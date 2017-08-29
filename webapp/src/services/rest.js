import { request, config } from 'utils'

const { api } = config
const { user } = api

export async function query (params) {
  return request({
    url: '/rest/api/v1/' + params.name + '/page',
    method: 'post',
    data: params.data,
  })
}

export async function create (params) {
  return request({
    url: users,
    method: 'post',
    data: params,
  })
}

export async function remove (params) {
  return request({
    url: user,
    method: 'delete',
    data: params,
  })
}

export async function update (params) {
  return request({
    url: user,
    method: 'patch',
    data: params,
  })
}
