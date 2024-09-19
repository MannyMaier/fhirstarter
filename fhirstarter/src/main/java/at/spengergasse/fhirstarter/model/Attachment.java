package at.spengergasse.fhirstarter.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "at_attachment")
@Builder
public class Attachment  extends Element{

    @Enumerated(EnumType.STRING)
    @Column(name = "at_contentType", length = 50)
    private MimeType contentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "at_language")
    private Language language;

    @Lob
    @Column(name = "at_data", columnDefinition = "LONGTEXT")
    private String data;

    @Column(name = "at_url")
    private String url;

    @Column(name = "at_size")
    Integer size;

    @Column(name = "at_hash")
    private String hash;

    @Column(name = "at_title")
    private String title;

    @Column(name = "at_creation")
    private LocalDateTime creation;

    @Column(name = "at_height")
    private Integer height;

    @Column(name = "at_width")
    private Integer width;

    @Column(name = "at_frames")
    private Integer frames;

    @Column(name = "at_duration")
    private Double duration;

    @Column(name = "at_pages")
    private Integer pages;
}
