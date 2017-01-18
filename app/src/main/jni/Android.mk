LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := test-jni
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	/Users/liuxiaoyao/AndroidStudioProjects/MyApplication/app/src/main/jni/test.cpp \

LOCAL_C_INCLUDES += /Users/liuxiaoyao/AndroidStudioProjects/MyApplication/app/src/main/jni
LOCAL_C_INCLUDES += /Users/liuxiaoyao/AndroidStudioProjects/MyApplication/app/src/debug/jni

include $(BUILD_SHARED_LIBRARY)
