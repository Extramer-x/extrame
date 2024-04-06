package top.extrame.common.enums;

import lombok.Getter;

@Getter
public enum FileType {

    AVI("AVI", "41564920"),
    BMP("BMP", "424D"),
    BMP_16("BMP", "424D228C010000000000"),
    BMP_24("BMP", "424D8240090000000000"),
    BMP_256("BMP", "424D8E1B030000000000"),
    CLASS("CLASS", "CAFEBABE0000002E00"),
    DBX("DBX", "CFAD12FEC5FD746F "),
    DOC("DOC", "D0CF11E0"),
    DOCX("DOCX", "504B0304"),
    DWG("DWG", "41433130"),
    ELF("ELF", "7F454C4601010100"),
    EML("EML", "44656C69766572792D646174653A"),
    EXE("EXE", "4D5A9000030000000400"),
    FLV("FLV", "464C5601050000000900"),
    GIF("GIF", "47494638"),
    HTML("HTML", "68746D6C3E"),
    JAR("JAR", "504B03040A000000"),
    JAVA("JAVA", "7061636B61676520"),
    JPEG("JPEG", "FFD8FF"),
    JPG("JPG", "FFD8FF"),
    JSP("JSP", "3C2540207061676520"),
    LWP("LWP", "576F726450726F"),
    MDB("MDB", "5374616E64617264204A"),
    MF("MF", "4D616E69666573742D56"),
    MID("MID", "4D546864"),
    MOV("MOV", "6D6F6F76"),
    MP3("MP3", "49443303000000002176"),
    MP4("MP4", "00000020667479706D70"),
    MPG("MPG", "000001BA"),
    OLE2("OLE2", "0xD0CF11E0A1B11AE1"),
    PDF("PDF", "25504446"),
    PNG("PNG", "89504E47"),
    PSD("PSD", "38425053"),
    PST("", "2142444E"),
    PWL("PWL", "E3828596"),
    RAM("RAM", "2E7261FD"),
    RM("RM", "2E524D46"),
    RMVB("RMVB", "2E524D46000000120001"),
    RTF("RTF", "7B5C727466"),
    SLY("SLY", "53520100"),
    TIFF("TIF", "49492A00"),
    TORRENT("TORRENT", "6431303A637265617465"),
    WAV("WAV", "57415645"),
    WK1("WK1", "2000604060"),
    WK3("WK3", "00001A0000100400"),
    WK4("WK4", "00001A0002100400"),
    XLS("XLS", "D0CF11E0"),
    XLSX("XLSX", "504B0304"),
    XML("XML", "3C3F786D6C");

    private final String suffix;

    private final String magicNumber;

    FileType(String suffix, String magicNumber) {
        this.suffix = suffix;
        this.magicNumber = magicNumber;
    }

    public static FileType getBySuffix(String suffix) {
        for (FileType fileType : FileType.values()) {
            if (fileType.getSuffix().equals(suffix.toUpperCase())) {
                return fileType;
            }
        }
        return null;
    }
}
