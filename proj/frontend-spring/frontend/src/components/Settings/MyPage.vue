<template>
  <v-card
    class="grey lighten-3 scroll fill-height "
    outline
    height="1000"
  >
    <v-layout column justify-center class="justify-center">
      <v-card-text class="display-1 text-center" v-model="userImg">프로필 사진</v-card-text>
      <v-flex align-self-center>
        <v-img
          class="justify-center v-img"
          src="https://cdn.vuetifyjs.com/images/john.jpg"
          max-width="200"
          v-model="userImg"
        ></v-img>
      </v-flex>
      <v-flex xs4>
        <v-text-field
          label="이름"
          v-model="userName"
        ></v-text-field>
      </v-flex>
      <v-text-field
        label="ID"
        v-model="userId"
      ></v-text-field>
      <v-text-field
        label="생년월일"
        v-model="userBirth"
      ></v-text-field>
      <v-text-field
        class="mt-5"
        label="주소"
        v-model="address"
      >
      </v-text-field>
      <v-text-field
        label="현재 비밀번호"
        v-model="curPw"
      ></v-text-field>
      <v-text-field
        label="바꿀 비밀번호"
        v-model="chPw"
      ></v-text-field>
      <v-text-field
        label="비밀번호 확인"
        v-model="chPw"
      ></v-text-field>
      <v-btn class="mb-10 primary">저장</v-btn>
    </v-layout>
  </v-card>
</template>

<script>
export default {
  name: 'MyPage',
  data () {
    return {
      userName: this.$store.state.myProfile[0].userName,
      userId: this.$store.state.myProfile[0].userId,
      userBirth: this.$store.state.myProfile[0].date,
      curPw: '',
      chPw: '',
      userImg: '',
      address: this.$store.state.myProfile[0].totalAddress
    }
  }
}
</script>
