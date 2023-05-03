import Vue from "vue";
import Vuex from 'vuex'
import router from "../router";

Vue.use(Vuex)

const store =new Vuex.Store ({
  state:{
    currentPathName:'',
    isFile:"",
  },
  mutations: {
    setPath (state) {
      state.currentPathName = localStorage.getItem("currentPathName")
    },
    setFile (state) {
      state.isFile = localStorage.getItem("isFile")
    },
  }
})

export default store
