<template>
  <v-card
    class="grey lighten-3 scroll fill-height "
    outline
    height="1000"
  >
    <v-row>
      <v-col class="mt-15 ml-15 mr-10">
        {{ this.$store.state.myProfile }}
        <v-text-field
          label="이름"
          :placeholder=this.$store.state.myProfile
          v-model="userName"
          hint=""
        ></v-text-field>
      </v-col>
      <v-col class="mt-15 ml-10 mr-15">
        <v-text-field
          label="ID"
          v-model="userId"
        ></v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="ml-15 mr-10">
        <v-text-field
          label="생년월일"
          v-model="userBirth"
        ></v-text-field>
        <v-text-field class="mt-5" label="주소"></v-text-field>
      </v-col>
      <v-col class="ml-10 mr-15">
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
      </v-col>
    </v-row>
    <v-row>
      <v-col class="ml-15" cols="12" md="4">
        <v-card-text
          class="display-1"
          v-model="userImg"
        >프로필 사진
        </v-card-text>
      </v-col>
      <v-col cols="12" md="4">
        <v-img
          src="https://cdn.vuetifyjs.com/images/john.jpg"
          max-width="200"
          v-model="userImg"
        ></v-img>
      </v-col>
    </v-row>
    <v-row class="fill-height justify-center">
      <v-btn
        class="mb-10 primary"
      >저장</v-btn>
    </v-row>
  </v-card>
</template>

<script>
export default {
  name: 'MyPage',
  data () {
    return {
      userName: '',
      userId: '',
      userBirth: '',
      curPw: '',
      chPw: '',
      userImg: '',
      address: ''
    }
  }
}
</script>
