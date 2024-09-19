package at.spengergasse.fhirstarter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MimeType {
    @JsonProperty("application/pdf") PDF,
    @JsonProperty("application/vnd.openxmlformats-officedocument.wordprocessingml.document") DOCX,
    @JsonProperty("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") XLSX,
    @JsonProperty("image/png") PNG,
    @JsonProperty("image/jpeg") JPEG,
    @JsonProperty("image/jpg") JPG,
    @JsonProperty("image/gif") GIF,
    @JsonProperty("audio/mpeg") MP3,
    @JsonProperty("audio/wav") WAV,
    @JsonProperty("video/mp4") MP4,
    @JsonProperty("video/x-msvideo") AVI,
    @JsonProperty("application/zip") ZIP,
    @JsonProperty("application/x-rar-compressed") RAR,
    @JsonProperty("application/json") JSON,
    @JsonProperty("text/plain") TXT,
    @JsonProperty("text/html") HTML,
    @JsonProperty("application/xml") XML,
    @JsonProperty("application/vnd.ms-powerpoint") PPT,
    @JsonProperty("application/vnd.openxmlformats-officedocument.presentationml.presentation") PPTX,
    @JsonProperty("application/x-7z-compressed") SEVEN_Z,
    @JsonProperty("application/x-tar") TAR
}














/* aac(".aac", "audio/aac"),
    abw(".abw", "application/x-abiword"),
    apng(".apng", "image/apng"),
    arc(".arc", "application/x-freearc"),
    avif(".avif", "image/avif"),
    avi(".avi", "video/x-msvideo"),
    azw(".azw", "application/vnd.amazon.ebook"),
    bin(".bin", "application/octet-stream"),
    bmp(".bmp", "image/bmp"),
    bz(".bz", "application/x-bzip"),
    bz2(".bz2", "application/x-bzip2"),
    cda(".cda", "application/x-cdf"),
    csh(".csh", "application/x-csh"),
    css(".css", "text/css"),
    csv(".csv", "text/csv"),
    doc(".doc", "application/msword"),
    docx(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    eot(".eot", "application/vnd.ms-fontobject"),
    epub(".epub", "application/epub+zip"),
    gz(".gz", "application/gzip"),
    gif(".gif", "image/gif"),
    htm(".htm", "text/html"),
    html(".html", "text/html"),
    ico(".ico", "image/vnd.microsoft.icon"),
    ics(".ics", "text/calendar"),
    jar(".jar", "application/java-archive"),*/
   /* jpeg("image/jpeg"),
    jpg("image/jpeg"),
    js( "text/javascript"),
    json("application/json"),
  /* jsonld(".jsonld", "application/ld+json"),
   mid(".mid", "audio/midi"),
   midi(".midi", "audio/midi"),
   mjs(".mjs", "text/javascript"),
   mp3(".mp3", "audio/mpeg"),
   mp4(".mp4", "video/mp4"),
   mpeg(".mpeg", "video/mpeg"),
   mpkg(".mpkg", "application/vnd.apple.installer+xml"),
   odp(".odp", "application/vnd.oasis.opendocument.presentation"),
   ods(".ods", "application/vnd.oasis.opendocument.spreadsheet"),
   odt(".odt", "application/vnd.oasis.opendocument.text"),
   oga(".oga", "audio/ogg"),
   ogv(".ogv", "video/ogg"),
   ogx(".ogx", "application/ogg"),
   opus(".opus", "audio/opus"),
   otf(".otf", "font/otf"),
   png(".png", "image/png"),
   pdf(".pdf", "application/pdf"),
   php(".php", "application/x-httpd-php"),
   ppt(".ppt", "application/vnd.ms-powerpoint"),
   pptx(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"),
   rar(".rar", "application/vnd.rar"),
   rtf(".rtf", "application/rtf"),
   sh(".sh", "application/x-sh"),
   svg(".svg", "image/svg+xml"),
   tar(".tar", "application/x-tar"),
   tiff(".tiff", "image/tiff"),
   ts(".ts", "video/mp2t"),
   ttf(".ttf", "font/ttf"),
   txt(".txt", "text/plain"),
   vsd(".vsd", "application/vnd.visio"),
   wav(".wav", "audio/wav"),
   weba(".weba", "audio/webm"),
   webm(".webm", "video/webm"),
   webp(".webp", "image/webp"),
   woff(".woff", "font/woff"),
   woff2(".woff2", "font/woff2"),
   xhtml(".xhtml", "application/xhtml+xml"),
   xls(".xls", "application/vnd.ms-excel"),
   xlsx(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
   xml(".xml", "application/xml"),
   xul(".xul", "application/vnd.mozilla.xul+xml"),
   zip(".zip", "application/zip"),
   three_gp(".3gp", "video/3gpp"),
   three_g2(".3g2", "video/3gpp2"),
   seven_z(".7z", "application/x-7z-compressed")*/
    ;

    //private final String extension;
   /* private final String mimeType;

    MimeType( String mimeType) {
    //   this.extension = extension;
        this.mimeType = mimeType;
    }

    /*public String getExtension() {
        return extension;
    }

    public String getMimeType() {
        return mimeType;
    }
}

*/