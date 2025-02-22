package com.mohistmc.network.download;


import com.mohistmc.configuration.MohistConfigUtil;

public enum DownloadSource {

    MOHIST("https://maven.mohistmc.com/"),
    CHINA("http://s1.devicloud.cn:25119/"),
    GITHUB("https://mavenmirror.mohistmc.com/");

    String url;

    DownloadSource(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static DownloadSource get(){
        String ds = MohistConfigUtil.sMohist("libraries_downloadsource", "MOHIST");
        for (DownloadSource me : DownloadSource.values()) {
            if (me.name().equalsIgnoreCase(ds))
                return me;
        }
        return DownloadSource.MOHIST;
    }
}
