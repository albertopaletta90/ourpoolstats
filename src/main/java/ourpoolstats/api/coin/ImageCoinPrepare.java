package ourpoolstats.api.coin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;

public class ImageCoinPrepare {
	
		
	public  ResponseEntity<Response> getImageCoin(@PathVariable("name") String name) {
		Response response = new Response();
		try {
			Market coingeko = CoinGekoClient.GetInstance().getInfoCoin(name);
			List<String>data = new ArrayList<>();
			data.add(coingeko.getImage());
			return new ResponseStatus().success(response, name, LogOperation.INFOCOIN, data);
		} catch (Exception e) {
			return new ResponseStatus().error(response, name, e, LogOperation.INFOCOIN);
		}
	}

}
