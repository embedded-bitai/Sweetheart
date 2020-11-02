import {
  SET_EDITING_ID,
  RESET_EDITING_ID,
  SET_FILTER,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  CRAWLSTARTDAUM,
  CRAWLSTARTNAVER,
  SET_MY_PROFILE,
  DESTROY_MY_PROFILE,
  CRAWLSTARTBITCAMP
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  [CRAWLSTARTBITCAMP] (state, payload) {
    state.bitCampLists = payload
  },
  [CRAWLSTARTNAVER] (state, payload) {
    state.naverLists = payload
  },
  [CRAWLSTARTDAUM] (state, payload) {
    state.daumLists = payload
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
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      console.log('SET_ACCESS_TOKEN()')
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken = ''
    delete axios.defaults.headers.common.Authorization
    cookies.remove('accessToken')
  },
  [SET_MY_INFO] (state, myInfo) {
    console.log('SET_MY_INFO: ' + myInfo)
    if (myInfo) {
      state.myInfo = myInfo
    }
  },
  [DESTROY_MY_INFO] (state) {
    state.myinfo = null
  },
  [DESTROY_MY_PROFILE] (state) {
    state.myProfile = null
  },
  [SET_MY_PROFILE] (state, myProfile) {
    console.log('SET_MY_PROFILE: ' + myProfile)
    if (myProfile) {
      state.myProfile = myProfile
    }
  }
}
