import { configureStore } from '@reduxjs/toolkit';
import { goods } from "./reducer/goods";

export const store = configureStore({
    reducer: {
        goods: goods
    },
})