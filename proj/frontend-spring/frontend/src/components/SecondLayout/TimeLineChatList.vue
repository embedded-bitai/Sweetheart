<template>
  <v-container class="pa-5">
    <v-card>
      <v-toolbar flat floating outlined width="100%" height="50%">
        <v-toolbar-title>Chatting List</v-toolbar-title>
      </v-toolbar>
      <v-layout column>
        <v-layout justify-center>
          <v-icon size="100">mdi-format-quote-open</v-icon>
          <v-icon size="100">mdi-format-quote-close</v-icon>
        </v-layout>
        <v-subheader class="justify-center">Create Chatting</v-subheader>
      </v-layout>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: 'TimeLineChatList'
}
</script>
