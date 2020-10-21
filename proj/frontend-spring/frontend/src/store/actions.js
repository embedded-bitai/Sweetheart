import {
  FETCH_BOARD,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  /* eslint-disable no-unused-vars */
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  /* Crawl */
  CRAWLSTART,
  CRAWLSTARTNAVER,
  SET_MY_PROFILE,
  DESTROY_MY_PROFILE
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {
  async crawlFindIT ({ commit }, category) {
    console.log('category: ' + category)
    axios.get('http://localhost:7777/' + `${category}`)
      .then(({ data }) => {
        commit(CRAWLSTART, data)
        if (window.location.pathname !== '/CrawlCategory') {
          router.push('/CrawlCategory')
        }
      })
  },
  async crawlFindNaverIT ({ commit }) {
    console.log('crawlFindNaverIT()')
    axios.get('http://localhost:7777/naver/')
      .then(({ data }) => {
        commit(CRAWLSTARTNAVER, data)
        console.log(data)
        if (window.location.pathname !== '/CrawlCategory') {
          router.push('/CrawlCategory')
        }
      })
  },
  fetchBoard ({ commit }, boardNo) {
    console.log('fetchBoard ' + commit + ', boardNo = ' + boardNo)
    return axios.get(`http://localhost:7777/boards/${boardNo}`)
      .then(res => {
        console.log('fetchBoard - res: ' + res.data)
        commit(FETCH_BOARD, res.data)
      })
  },
  login ({ commit }, payload) {
    console.log('actions login()')
    return axios.get('http://localhost:5000/faceLogin')
      .then(res => {
        console.log('after face login() - ' + res)

        return axios.post(`http://localhost:7777/api/authenticate?username=${payload.userId}&password=${payload.userPassword}`, {
          username: payload.userId,
          password: payload.password
        }).then(res => {
          console.log('actions after post')
          const { authorization } = res.headers
          const accessToken = authorization.substring(7)

          commit(SET_ACCESS_TOKEN, accessToken)

          return axios.get('http://localhost:7777/users/myAuthInfo')
        }).then(res => {
          console.log('After Get Auth Info: ' + res.data)
          commit(SET_MY_INFO, res.data)

          const userNo = res.data.userNo

          console.log('userNo: ' + userNo)
          return axios.get(`http://localhost:7777/users/${userNo}`)
        }).then(res => {
          console.log('my account info save')
          commit(SET_MY_PROFILE, res.data)
        })
      })
  },
  loginByToken ({ commit }, token) {
    commit(SET_ACCESS_TOKEN, token)
    return axios.get('http://localhost:7777/users/myAuthInfo')
      .then(res => {
        commit(SET_MY_INFO, res.data)
      })
  },
  logout ({ commit }) {
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
    commit(DESTROY_MY_PROFILE)
  }
}
