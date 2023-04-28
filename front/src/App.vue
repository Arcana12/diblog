<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import SideBar from "@/components/SideBar.vue";


</script>


<template>
    <div class="common-layout">
        <el-container>
            <el-aside width="300px">
                <SideBar></SideBar>
            </el-aside>
            <el-main class="mx-lg-auto">
                <RouterView/>
            </el-main>
        </el-container>
    </div>
</template>

<style>
body{
    font-family: "Pretendard Variable", Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto,
    "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol",
    sans-serif;
    margin: 0px;
}

</style>