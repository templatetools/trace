import { request, config } from 'utils'

const { api } = config
const { menus } = api

export async function query (params) {
  return request({
    url: menus + '/list',
    method: 'post',
    data: {},
  })
}
