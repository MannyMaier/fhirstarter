package at.spengergasse.fhirstarter.model;

public enum Language {
    ar("Arabic"),
    bg("Bulgarian"),
    bg_bg("Bulgarian (Bulgaria)"),
    bn("Bengali"),
    cs("Czech"),
    cs_cz("Czech (Czechia)"),
    bs("Bosnian"),
    bs_ba("Bosnian (Bosnia and Herzegovina)"),
    da("Danish"),
    da_dk("Danish (Denmark)"),
    de("German"),
    de_at("German (Austria)"),
    de_ch("German (Switzerland)"),
    de_de("German (Germany)"),
    el("Greek"),
    el_gr("Greek (Greece)"),
    en("English"),
    en_au("English (Australia)"),
    en_ca("English (Canada)"),
    en_gb("English (Great Britain)"),
    en_in("English (India)"),
    en_nz("English (New Zealand)"),
    en_sg("English (Singapore)"),
    en_us("English (United States)"),
    es("Spanish"),
    es_ar("Spanish (Argentina)"),
    es_es("Spanish (Spain)"),
    es_uy("Spanish (Uruguay)"),
    et("Estonian"),
    et_ee("Estonian (Estonia)"),
    fi("Finnish"),
    fr("French"),
    fr_be("French (Belgium)"),
    fr_ch("French (Switzerland)"),
    fr_fr("French (France)"),
    fi_fi("Finnish (Finland)"),
    fr_ca("French (Canada)"),
    fy("Frisian"),
    fy_nl("Frisian (Netherlands)"),
    hi("Hindi"),
    hr("Croatian"),
    hr_hr("Croatian (Croatia)"),
    is("Icelandic"),
    is_is("Icelandic (Iceland)"),
    it("Italian"),
    it_ch("Italian (Switzerland)"),
    it_it("Italian (Italy)"),
    ja("Japanese"),
    ko("Korean"),
    lt("Lithuanian"),
    lt_lt("Lithuanian (Lithuania)"),
    lv("Latvian"),
    lv_lv("Latvian (Latvia)"),
    nl("Dutch"),
    nl_be("Dutch (Belgium)"),
    nl_nl("Dutch (Netherlands)"),
    no("Norwegian"),
    no_no("Norwegian (Norway)"),
    pa("Punjabi"),
    pl("Polish"),
    pl_pl("Polish (Poland)"),
    pt("Portuguese"),
    pt_pt("Portuguese (Portugal)"),
    pt_br("Portuguese (Brazil)"),
    ro("Romanian"),
    ro_ro("Romanian (Romania)"),
    ru("Russian"),
    ru_ru("Russian (Russia)"),
    sk("Slovakian"),
    sk_sk("Slovakian (Slovakia)"),
    sl("Slovenian"),
    sl_si("Slovenian (Slovenia)"),
    sr("Serbian"),
    sr_rs("Serbian (Serbia)"),
    sv("Swedish"),
    sv_se("Swedish (Sweden)"),
    te("Telugu"),
    zh("Chinese"),
    zh_cn("Chinese (China)"),
    zh_hk("Chinese (Hong Kong)"),
    zh_sg("Chinese (Singapore)"),
    zh_tw("Chinese (Taiwan)");

    private final String description;

    Language(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
