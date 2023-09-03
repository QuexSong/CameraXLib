# CompatLib
优化中

## 引用依赖
Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies{
    //CameraXLib 
    implementation 'com.github.QuexSong:CameraXLib:1.0.8'
    //需要在项目中添加cameraX相关依赖
    def camerax_version = "1.3.0-alpha04"
    implementation "androidx.camera:camera-core:${camerax_version}"
    implementation "androidx.camera:camera-camera2:${camerax_version}"
    implementation "androidx.camera:camera-lifecycle:${camerax_version}"
    implementation "androidx.camera:camera-view:${camerax_version}"
    //图片预览 使用了以下相关开源库
    //使用了第三方库 glide
    implementation 'com.github.bumptech.glide:glide:4.15.1'
    //使用了第三方库 PhotoView
    implementation 'com.github.chrisbanes:PhotoView:2.3.0'
}
```

## 调用方法 请参考Demo中 MediaActivity
注：需要在onCreate中创建兼容类
```java
public class MainActivity extends AppCompatActivity {
    private TakeCameraXCompat mTakeCameraXCompat;

    /**
     * 在onCreate中初始化兼容类
     */
    private void initCompat(){
         mTakeCameraXCompat = new TakeCameraXCompat(this){
            @Override
            public void onPermissionsDenied(List<String> perms) {
                super.onPermissionsDenied(perms);
                //此处处理未赋予权限问题
            }
        };
    }

    /**
     * 点击调用摄像头拍照
     */
    private void onClickCompat(){
        mTakeCameraXCompat.takeCamera(new TakeCameraXCompat.TakeCameraXCompatListener() {
            @Override
            public void onResult(Uri uri) {
                //回调结果
            }
        });
    }

}
```