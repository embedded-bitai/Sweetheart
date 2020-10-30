import {
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  /* eslint-disable no-unused-vars */
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  /* Crawl */
  CRAWLSTARTDAUM,
  CRAWLSTARTNAVER,
  SET_MY_PROFILE,
  DESTROY_MY_PROFILE,
  CRAWLSTARTBITCAMP
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {
  data () {
    return {
      userNo: this.$store.state.userNo
    }
  },
  async crawlBitCamp ({ commit }) {
    console.log('crawlBitCamp() ')
    axios.get('http://localhost:7777/crawlBitCamp')
      .then(({ data }) => {
        commit(CRAWLSTARTBITCAMP, data)
        if (window.location.pathname !== '/MainDashBoard') {
          router.push('/MainDashBoard')
        }
      })
  },
  async crawlDaumNews ({ commit }) {
    console.log('crawlDaumNews() ')
    axios.get('http://localhost:7777/crawlDaumNews')
      .then(({ data }) => {
        commit(CRAWLSTARTDAUM, data)
        if (window.location.pathname !== '/MainDashBoard') {
          router.push('/MainDashBoard')
        }
      })
  },
  async crawlNaverNews ({ commit }) {
    console.log('crawlNaverNews() ')
    axios.get('http://localhost:7777/crawlNaverNews')
      .then(({ data }) => {
        commit(CRAWLSTARTNAVER, data)
        if (window.location.pathname !== '/MainDashBoard') {
          router.push('/MainDashBoard')
        }
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

          this.userNo = res.data.userNo

          console.log('userNo: ' + this.userNo)
          return axios.get('http://localhost:7777/users/myInfo')
        }).then(res => {
          console.log('After Get My Profile: ' + res.data)
          commit(SET_MY_PROFILE, res.data)

          const userName = res.data.username

          console.log('userName: ' + userName)
        })
      })
  },
  loginByToken ({ commit }, token) {
    commit(SET_ACCESS_TOKEN, token)
    return axios.get('http://localhost:7777/users/myAuthInfo')
      .then(res => {
        commit(SET_MY_INFO, res.data)

        return axios.get('http://localhost:7777/users/myInfo')
      }).then(res => {
        commit(SET_MY_PROFILE, res.data)
      })
  },
  logout ({ commit }) {
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
    commit(DESTROY_MY_PROFILE)
  }
}
