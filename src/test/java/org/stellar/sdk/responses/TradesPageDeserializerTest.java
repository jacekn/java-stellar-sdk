package org.stellar.sdk.responses;

import com.google.common.base.Optional;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;
import org.junit.Test;
import org.stellar.sdk.AssetTypeNative;
import org.stellar.sdk.LiquidityPoolID;

import static java.lang.Long.valueOf;
import static org.stellar.sdk.Asset.create;

public class TradesPageDeserializerTest extends TestCase {
    @Test
    public void testDeserialize() {
        Page<TradeResponse> tradesPage = GsonSingleton.getInstance().fromJson(json, new TypeToken<Page<TradeResponse>>() {}.getType());

        assertEquals(tradesPage.getLinks().getNext().getHref(), "https://horizon.stellar.org/trades?cursor=3748308153536513-0&limit=10&order=asc");
        assertEquals(tradesPage.getLinks().getPrev().getHref(), "https://horizon.stellar.org/trades?cursor=3697472920621057-0&limit=10&order=desc");
        assertEquals(tradesPage.getLinks().getSelf().getHref(), "https://horizon.stellar.org/trades?cursor=&limit=10&order=asc");

        assertEquals(tradesPage.getRecords().get(0).getId(), "3697472920621057-0");
        assertEquals(tradesPage.getRecords().get(0).getPagingToken(), "3697472920621057-0");
        assertEquals(tradesPage.getRecords().get(0).getLedgerCloseTime(), "2015-11-18T03:47:47Z");
        assertEquals(tradesPage.getRecords().get(0).getOfferId(), valueOf(9));
        assertEquals(tradesPage.getRecords().get(0).getBaseOfferId(), Optional.of(valueOf(10)));
        assertEquals(tradesPage.getRecords().get(0).getCounterOfferId(), Optional.of(valueOf(11)));
        assertEquals(tradesPage.getRecords().get(0).getBaseAsset(), new AssetTypeNative());
        assertEquals(tradesPage.getRecords().get(0).getCounterAsset(), create(null,"JPY", "GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM"));
        assertEquals(tradesPage.getRecords().get(0).getPrice().getNumerator(), valueOf(267));
        assertEquals(tradesPage.getRecords().get(0).getPrice().getDenominator(), valueOf(1000));
        assertEquals(tradesPage.getRecords().get(0).getCounterLiquidityPoolID(), Optional.absent());
        assertEquals(tradesPage.getRecords().get(0).getBaseLiquidityPoolID(), Optional.absent());

        assertEquals(tradesPage.getRecords().get(1).getBaseAccount(), Optional.of("GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G"));
    }
    @Test
    public void testDeserializeLiquidityPool() {
        Page<TradeResponse> tradesPage = GsonSingleton.getInstance().fromJson(jsonLiquidityPool, new TypeToken<Page<TradeResponse>>() {}.getType());
        
        
        assertEquals(tradesPage.getRecords().get(0).getBaseLiquidityPoolID(), Optional.of(new LiquidityPoolID("a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7bbase")));
        assertEquals(tradesPage.getRecords().get(0).getCounterLiquidityPoolID(), Optional.absent());
        assertEquals(tradesPage.getRecords().get(1).getBaseLiquidityPoolID(), Optional.absent());
        assertEquals(tradesPage.getRecords().get(1).getCounterLiquidityPoolID(), Optional.of(new LiquidityPoolID("a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088")));
    }

    String json = "{\n" +
            "  \"_links\": {\n" +
            "    \"self\": {\n" +
            "      \"href\": \"https://horizon.stellar.org/trades?cursor=\\u0026limit=10\\u0026order=asc\"\n" +
            "    },\n" +
            "    \"next\": {\n" +
            "      \"href\": \"https://horizon.stellar.org/trades?cursor=3748308153536513-0\\u0026limit=10\\u0026order=asc\"\n" +
            "    },\n" +
            "    \"prev\": {\n" +
            "      \"href\": \"https://horizon.stellar.org/trades?cursor=3697472920621057-0\\u0026limit=10\\u0026order=desc\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"_embedded\": {\n" +
            "    \"records\": [\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3697472920621057\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3697472920621057-0\",\n" +
            "        \"paging_token\": \"3697472920621057-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T03:47:47Z\",\n" +
            "        \"offer_id\": \"9\",\n" +
            "        \"base_offer_id\": \"10\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_offer_id\": \"11\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"2.6700000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 267,\n" +
            "          \"d\": 1000\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3697472920621057\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3697472920621057-1\",\n" +
            "        \"paging_token\": \"3697472920621057-1\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T03:47:47Z\",\n" +
            "        \"offer_id\": \"4\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"2.6800000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 67,\n" +
            "          \"d\": 250\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3697472920621057\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3697472920621057-2\",\n" +
            "        \"paging_token\": \"3697472920621057-2\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T03:47:47Z\",\n" +
            "        \"offer_id\": \"8\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"20.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"5.3600000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 67,\n" +
            "          \"d\": 250\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3712329212497921\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3712329212497921-0\",\n" +
            "        \"paging_token\": \"3712329212497921-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T07:26:21Z\",\n" +
            "        \"offer_id\": \"36\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"5.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"1.2000192\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": false,\n" +
            "        \"price\": {\n" +
            "          \"n\": 5000,\n" +
            "          \"d\": 20833\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3716237632737281\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3716237632737281-0\",\n" +
            "        \"paging_token\": \"3716237632737281-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T08:27:26Z\",\n" +
            "        \"offer_id\": \"37\",\n" +
            "        \"base_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"counter_amount\": \"2.4500000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 49,\n" +
            "          \"d\": 200\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3716302057246721\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3716302057246721-0\",\n" +
            "        \"paging_token\": \"3716302057246721-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T08:28:40Z\",\n" +
            "        \"offer_id\": \"35\",\n" +
            "        \"base_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"counter_amount\": \"2.5000000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 1,\n" +
            "          \"d\": 4\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3716302057246721\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3716302057246721-1\",\n" +
            "        \"paging_token\": \"3716302057246721-1\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T08:28:40Z\",\n" +
            "        \"offer_id\": \"34\",\n" +
            "        \"base_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"counter_amount\": \"3.0000000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 3,\n" +
            "          \"d\": 10\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3725961438695425\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3725961438695425-0\",\n" +
            "        \"paging_token\": \"3725961438695425-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T11:09:30Z\",\n" +
            "        \"offer_id\": \"47\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"5.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"1.0000000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": false,\n" +
            "        \"price\": {\n" +
            "          \"n\": 1,\n" +
            "          \"d\": 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3748080520269825\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3748080520269825-0\",\n" +
            "        \"paging_token\": \"3748080520269825-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T16:56:09Z\",\n" +
            "        \"offer_id\": \"53\",\n" +
            "        \"base_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"base_amount\": \"10.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"counter_amount\": \"3.0000000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 3,\n" +
            "          \"d\": 10\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"_links\": {\n" +
            "          \"self\": {\n" +
            "            \"href\": \"\"\n" +
            "          },\n" +
            "          \"base\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\"\n" +
            "          },\n" +
            "          \"counter\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/accounts/GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\"\n" +
            "          },\n" +
            "          \"operation\": {\n" +
            "            \"href\": \"https://horizon.stellar.org/operations/3748308153536513\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"id\": \"3748308153536513-0\",\n" +
            "        \"paging_token\": \"3748308153536513-0\",\n" +
            "        \"ledger_close_time\": \"2015-11-18T16:59:37Z\",\n" +
            "        \"offer_id\": \"59\",\n" +
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" +
            "        \"base_amount\": \"30.0000000\",\n" +
            "        \"base_asset_type\": \"native\",\n" +
            "        \"counter_account\": \"GBB4JST32UWKOLGYYSCEYBHBCOFL2TGBHDVOMZP462ET4ZRD4ULA7S2L\",\n" +
            "        \"counter_amount\": \"9.0000000\",\n" +
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" +
            "        \"counter_asset_code\": \"JPY\",\n" +
            "        \"counter_asset_issuer\": \"GBVAOIACNSB7OVUXJYC5UE2D4YK2F7A24T7EE5YOMN4CE6GCHUTOUQXM\",\n" +
            "        \"base_is_seller\": true,\n" +
            "        \"price\": {\n" +
            "          \"n\": 3,\n" +
            "          \"d\": 10\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    
    
    String jsonLiquidityPool = 
            "{\n" + 
            "  \"_links\": {\n" + 
            "    \"self\": {\n" + 
            "      \"href\": \"https://horizon.stellar.org/liquidity_pools/a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088/trades?cursor=&limit=10&order=asc\"\n" + 
            "    },\n" + 
            "    \"next\": {\n" + 
            "      \"href\": \"https://horizon.stellar.org/liquidity_pools/a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088/trades?cursor=163706513893126145-0&limit=10&order=asc\"\n" + 
            "    },\n" + 
            "    \"prev\": {\n" + 
            "      \"href\": \"https://horizon.stellar.org/liquidity_pools/a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088/trades?cursor=163706170297630721-3&limit=10&order=desc\"\n" + 
            "    }\n" + 
            "  },\n" + 
            "  \"_embedded\": {\n" + 
            "    \"records\": [\n" + 
            "      {\n" + 
            "        \"_links\": {\n" + 
            "          \"self\": {\n" + 
            "            \"href\": \"\"\n" + 
            "          },\n" + 
            "          \"base\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/liquidity_pools/a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088\"\n" + 
            "          },\n" + 
            "          \"counter\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/accounts/GAVYIUWQFQX2GJ7FWNGVXSSLMJO75V5XY5M2YON4DKYD24LPB6QLCERP\"\n" + 
            "          },\n" + 
            "          \"operation\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/operations/163706170297630721\"\n" + 
            "          }\n" + 
            "        },\n" + 
            "        \"id\": \"163706170297630721-3\",\n" + 
            "        \"paging_token\": \"163706170297630721-3\",\n" + 
            "        \"ledger_close_time\": \"2021-11-03T15:00:52Z\",\n" + 
            "        \"trade_type\": \"liquidity_pool\",\n" + 
            "        \"liquidity_pool_fee_bp\": 30,\n" + 
            "        \"base_liquidity_pool_id\": \"a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7bbase\",\n" + 
            "        \"base_amount\": \"0.0010000\",\n" + 
            "        \"base_asset_type\": \"native\",\n" + 
            "        \"counter_offer_id\": \"4775392188725018625\",\n" + 
            "        \"counter_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" + 
            "        \"counter_amount\": \"0.0003679\",\n" + 
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" + 
            "        \"counter_asset_code\": \"USDC\",\n" + 
            "        \"counter_asset_issuer\": \"GA5ZSEJYB37JRC5AVCIA5MOP4RHTM335X2KGX3IHOJAPP5RE34K4KZVN\",\n" + 
            "        \"base_is_seller\": true,\n" + 
            "        \"price\": {\n" + 
            "          \"n\": \"3679\",\n" + 
            "          \"d\": \"10000\"\n" + 
            "        }\n" + 
            "      },\n" + 
            
            "      {\n" + 
            "        \"_links\": {\n" + 
            "          \"self\": {\n" + 
            "            \"href\": \"\"\n" + 
            "          },\n" + 
            "          \"base\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/accounts/GA7BRV2K3OM27NLVY2IJQGYZEQ7AEZSPR3Y3XA6COHPMOPOEUHQBDYBC\"\n" + 
            "          },\n" + 
            "          \"counter\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/liquidity_pools/a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088\"\n" + 
            "          },\n" + 
            "          \"operation\": {\n" + 
            "            \"href\": \"https://horizon.stellar.org/operations/163706436584558593\"\n" + 
            "          }\n" + 
            "        },\n" + 
            "        \"id\": \"163706436584558593-1\",\n" + 
            "        \"paging_token\": \"163706436584558593-1\",\n" + 
            "        \"ledger_close_time\": \"2021-11-03T15:07:00Z\",\n" + 
            "        \"trade_type\": \"liquidity_pool\",\n" + 
            "        \"liquidity_pool_fee_bp\": 30,\n" + 
            "        \"base_offer_id\": \"4775392455011946497\",\n" + 
            "        \"base_account\": \"GAVH5JM5OKXGMQDS7YPRJ4MQCPXJUGH26LYQPQJ4SOMOJ4SXY472ZM7G\",\n" + 
            "        \"base_amount\": \"0.0002207\",\n" + 
            "        \"base_asset_type\": \"native\",\n" + 
            "        \"counter_liquidity_pool_id\": \"a468d41d8e9b8f3c7209651608b74b7db7ac9952dcae0cdf24871d1d9c7b0088\",\n" + 
            "        \"counter_amount\": \"0.0000831\",\n" + 
            "        \"counter_asset_type\": \"credit_alphanum4\",\n" + 
            "        \"counter_asset_code\": \"USDC\",\n" + 
            "        \"counter_asset_issuer\": \"GA5ZSEJYB37JRC5AVCIA5MOP4RHTM335X2KGX3IHOJAPP5RE34K4KZVN\",\n" + 
            "        \"base_is_seller\": false,\n" + 
            "        \"price\": {\n" + 
            "          \"n\": \"831\",\n" + 
            "          \"d\": \"2207\"\n" + 
            "        }\n" + 
            "      },\n" + 
            "    ]\n" + 
            "  }\n" + 
            "}\n" + 
            "\n";

}
