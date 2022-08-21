package devices;

public enum DeviceFarm {
    ANDROID_OREO("src/test/resources/capabilities/android-oreo.json");
    public final String path;
    DeviceFarm(String path){
        this.path = path;
    }
}
