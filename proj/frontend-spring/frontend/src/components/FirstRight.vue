<template>
 <div id="firstRight">
   <v-container>
     <v-layout>
       <v-card-text class="white--text ma-8">
         <h1 class="text-center display-2">Login Recent!</h1>
       </v-card-text>
     </v-layout>
     <v-layout justify-center class="green">
       <v-badge
         avatar
         bordered
         overlap
       >
         <template v-slot:badge>
           <v-avatar>
             <v-img
               src="https://cdn.vuetifyjs.com/images/logos/v.png"
             ></v-img>
           </v-avatar>
         </template>
         <v-avatar>
           <v-img
             src="https://cdn.vuetifyjs.com/images/john.png"
           ></v-img>
         </v-avatar>
       </v-badge>
     </v-layout>
   </v-container>
 </div>
</template>

<script>
export default {
  name: 'FirstRight'
}
</script>
