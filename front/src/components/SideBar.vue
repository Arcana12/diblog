<template>
    <el-scrollbar style="background-color: #F4F6F9" height="100vh">
        <el-menu
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="#F4F6F9"
        >
            <el-row class="mt-4 mb-5 main-manu">
                <el-col :span="12" style="text-align: center">
                    <RouterLink to="/">Diblog</RouterLink>
                </el-col>
                <el-col :span="12" style="text-align: center">
                    <RouterLink to="/write">글 작성</RouterLink>
                </el-col>
            </el-row>


            <div class="block" style="text-align: center">
                <el-avatar :size="170" src="/wbb.jpg"/>
            </div>
            <div style="text-align: center">
                <h2>Dae Il Jung</h2>
                <p>개발자</p>
            </div>

            <el-sub-menu index="1">
                <template #title>
                    <span>Study</span>
                </template>
                <el-menu-item index="1-1">Java</el-menu-item>
                <el-menu-item index="1-2">Spring</el-menu-item>
                <el-menu-item index="1-3">Algorithm</el-menu-item>
                <el-menu-item index="1-4">JPA</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="2">
                <span>잡담</span>
            </el-menu-item>
            <el-menu-item index="4">
                <span>Game Life</span>
            </el-menu-item>
        </el-menu>
    </el-scrollbar>
</template>

<script lang="ts" setup>
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'
import {RouterLink} from "vue-router";

const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}

</script>

<style scoped lang="scss">
.main-manu a{
    text-decoration: none;
    color: #303030;
}

</style>