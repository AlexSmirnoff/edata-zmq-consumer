package demo.elitedata.zmqconsumer.enums;

import java.util.Arrays;

import com.jayway.jsonpath.JsonPath;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public enum EddnSchema {
    FSD_JUMP("https://eddn.edcd.io/schemas/journal/1", "FSDJump"),
    LOCATION("https://eddn.edcd.io/schemas/journal/1", "Location"),
    DOCKED("https://eddn.edcd.io/schemas/journal/1", "Docked"),
    SCAN("https://eddn.edcd.io/schemas/journal/1", "Scan"),
    CARRIER_JUMP("https://eddn.edcd.io/schemas/journal/1", "CarrierJump"),
    SAA_SIGNALS_FOUND("https://eddn.edcd.io/schemas/journal/1", "SAASignalsFound"),
    COMMODITIES("https://eddn.edcd.io/schemas/commodity/3", null),
    FSS_ALL_BODIES_FOUND("https://eddn.edcd.io/schemas/fssallbodiesfound/1", "FSSAllBodiesFound"),
    FSS_DISCOVERY_SCAN("https://eddn.edcd.io/schemas/fssdiscoveryscan/1", "FSSDiscoveryScan"),
    NAVBEACON_SCAN("https://eddn.edcd.io/schemas/navbeaconscan/1", "NavBeaconScan"),
    NAVROUTE("https://eddn.edcd.io/schemas/navroute/1", "NavRoute"),
    APPROACH_SETTLEMENT("https://eddn.edcd.io/schemas/approachsettlement/1", "ApproachSettlement"),
    SCAN_BARY_CENTRE("https://eddn.edcd.io/schemas/scanbarycentre/1", "ScanBaryCentre"),
    OUTFITTING("https://eddn.edcd.io/schemas/outfitting/2", null),
    SHIPYARD("https://eddn.edcd.io/schemas/shipyard/2", null),
    CODEX_ENTRY("https://eddn.edcd.io/schemas/codexentry/1", "CodexEntry"),
    DEFAULT(null, null)
    ;

    private final String schemaRef;
    private final String event;

    EddnSchema(String schemaRef, String event) {
        this.schemaRef = schemaRef;
        this.event = event;
    }

    public static EddnSchema findSchemaByMessage(String message){
        String schemaRef = JsonPath.read(message, "$.$schemaRef");
        String event = null;
        try {
            event = JsonPath.read(message, "$.message.event");
        } catch (Exception e) {
            //consume silently
        }
        final var finalEvent = event;
        return Arrays.stream(EddnSchema.values())
            .filter(schema -> StringUtils.equalsIgnoreCase(schema.getSchemaRef(), schemaRef) && StringUtils.equalsIgnoreCase(schema.getEvent(), finalEvent))
            .findFirst()
            .orElse(DEFAULT);
    }
}
