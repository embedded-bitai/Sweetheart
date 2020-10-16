<template>
  <v-container style="max-width: 100%; max-height: 100%;">
    <h2>Create login</h2>
    <div>Use your email for registration</div>
    <input type="text" placeholder="Name" />
    <input type="NickName" placeholder="NickName" />
    <input type="email" placeholder="Email" />
    <input type="password" placeholder="Password" />
    <input type="password" placeholder="PasswordCheck" />
    <input type="birth" placeholder="Birth" />
    <input type="sex" placeholder="sex" />
    <input type="phone" placeholder="Phone" />
    <input type="address" placeholder="Address" />
    <a href="test">To certify the Face</a>
    <button>회원가입</button>
  </v-container>
</template>

<script>
export default {
  name: 'SignUpCompo'
}
</script>
