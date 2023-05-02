import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import "normalize.css"

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import "bootstrap/dist/css/bootstrap-utilities.css"
import axios from "axios";

const app = createApp(App)

app.config.globalProperties.$axios = axios
app.use(ElementPlus)
app.use(createPinia())
app.use(router)

app.mount('#app')
