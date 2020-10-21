export default {
  isAuthorized (state) {
    console.log('accessToken 길이: ' + state.accessToken.length)
    console.log('내 정보: ' + state.myinfo)
    const tokenLength = state.accessToken.length
    const myInfor = state.myProfile

    return tokenLength && !!myInfor
  }
}
