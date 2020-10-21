import {
  SET_EDITING_ID,
  RESET_EDITING_ID,
  SET_FILTER,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  CRAWLSTART,
  FINDONE,
  CRAWLSTARTNAVER,
  ADDSEARCH,
  SET_MY_PROFILE,
  DESTROY_MY_PROFILE
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  [DESTROY_MY_PROFILE] (state) {
    state.myProfile = null
  },
  [SET_MY_PROFILE] (state, myProfile) {
    console.log('SET_MY_PROFILE: ' + myProfile)
    if (myProfile) {
      state.myProfile = myProfile
    }
  },
  [ADDSEARCH] (state, payload) {
    console.log('mutations - ADDSEARCH(): ' + payload)
    const { content } = payload
    state.searchList.push({ content, done: false })
  },
  [CRAWLSTARTNAVER] (state, payload) {
    state.naverLists = payload
  },
  [CRAWLSTART] (state, payload) {
    state.lists = payload
  },
  [CRAWLSTART] (state, payload) {
    state.lists = payload
  },
  [FINDONE] (state, payload) {
    state.news = payload
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },
  [SET_FILTER] (state, filter) {
    state.filter = filter
  },
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      console.log('SET_ACCESS_TOKEN() - accessToken: ' + accessToken)
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [SET_MY_INFO] (state, myInfo) {
    console.log('SET_MY_INFO: ' + myInfo)
    if (myInfo) {
      state.myInfo = myInfo
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken = ''
    delete axios.defaults.headers.common.Authorization
    cookies.remove('accessToken')
  },
  [DESTROY_MY_INFO] (state) {
    state.myinfo = null
  }
}
