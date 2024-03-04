/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

public final class InputVrachtwagens { // final voorkomt overerving van deze class
    private InputVrachtwagens() {}     // private constructor voorkomt instantiering van deze class
                                       
    public static final Entry[] aangemelde_vrachtwagens = {
        new Entry("J-708-WW", new Container(0, "Bananen")),
        new Entry("K-405-PL", new Container(1, "Arduino's")),
        new Entry("A-744-RT", new Container(2, "Blauw zout")),
        new Entry("J-709-WW", new Container(3, "Tapijten")),
        new Entry("Y-509-XX", new Container(4, "Iemands tiny house")),
        new Entry("U-683-JC", new Container(5, "Banden")),
        new Entry("M-996-SK", new Container(6, "Oude kaas")),
        new Entry("C-114-ZF", new Container(7, "Schoenen")),
        new Entry("J-550-TL", new Container(8, "3D-printers")),
        new Entry("X-788-WP", new Container(9, "Sambalmansambal")),
        new Entry("G-708-WW", new Container(10, "Speciaalbier")),
        new Entry("A-744-RT", new Container(11, "Niet-gedeclareerde variabelen")),
        new Entry("Q-491-NA", new Container(12, "De F1-auto van Max Verstappen")),
        new Entry("F-094-YN", new Container(13, "Middelradioactief afval (goed ingepakt)")),
        new Entry("P-102-AA", new Container(14, "Tulpen")),
        new Entry("Z-111-ZZ", new Container(15, "Tandartsstoel")),
        new Entry("V-676-EG", new Container(16, "Turbo Encabulators")),
        new Entry("J-263-PR", new Container(17, "Disco")),
        new Entry("G-900-IO", new Container(18, "Handbalballen")),
        new Entry("A-009-PP", new Container(19, "Koffiebonen")),
        new Entry("I-610-TO", new Container(20, "Plastic koffiebekers")),
        new Entry("J-708-WW", new Container(21, "'Bananen'")),
        new Entry("Q-010-IO", new Container(22, "Horloges")),
        new Entry("M-109-KL", new Container(23, "Lege pallets")),
        new Entry("Z-111-ZZ", new Container(24, "'Poedersuiker'")),
        new Entry("E-456-AO", new Container(25, "Motorolie")),
        new Entry("H-253-TE", new Container(26, "De Lord of the Rings Trilogie (extended cut+deleted scenes)")),
        new Entry("C-089-OA", new Container(27, "Drones")),
        new Entry("P-435-RO", new Container(28, "Videokaarten")),
        new Entry("U-780-MU", new Container(29, "To-to-to-tomaten"))
    };
}
