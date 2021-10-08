package id.ac.umn.grivia_36794_uts;

import android.os.Parcel;
import android.os.Parcelable;

public class SumberAudioSaya implements Parcelable {
    private String judulAudio;
    private String keteranganAudio;
    private String audioURI;

    public SumberAudioSaya(String judulAudio, String keteranganAudio, String audioURI) {
        this.judulAudio = judulAudio;
        this.keteranganAudio = keteranganAudio;
        this.audioURI = audioURI;
    }

    protected SumberAudioSaya(Parcel in) {
        judulAudio = in.readString();
        keteranganAudio = in.readString();
        audioURI = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judulAudio);
        dest.writeString(keteranganAudio);
        dest.writeString(audioURI);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SumberAudioSaya> CREATOR = new Creator<SumberAudioSaya>() {
        @Override
        public SumberAudioSaya createFromParcel(Parcel in) {
            return new SumberAudioSaya(in);
        }

        @Override
        public SumberAudioSaya[] newArray(int size) {
            return new SumberAudioSaya[size];
        }
    };

    public String getJudulAudio() {
        return judulAudio;
    }
    public void setJudulAudio(String judulAudio) {
        this.judulAudio = judulAudio;
    }

    public String getKeteranganAudio() {
        return keteranganAudio;
    }
    public void setKeteranganAudio(String keteranganAudio) {
        this.keteranganAudio = keteranganAudio;
    }

    public String getAudioURI() {
        return audioURI;
    }
    public void setAudioURI(String audioURI) {
        this.audioURI = audioURI;
    }
}
