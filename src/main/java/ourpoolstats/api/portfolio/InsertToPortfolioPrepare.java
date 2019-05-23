package ourpoolstats.api.portfolio;

import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Portfolio;
import ourpoolstats.query.QueryPortfolio;
import ourpoolstats.response.ResponsePortfolio;
import ourpoolstats.response.status.PortofolioResponseStatus;
import ourpoolstats.utility.connection.GetConnection;

public class InsertToPortfolioPrepare {

	public ResponseEntity<ResponsePortfolio> insertToPortfolio(Portfolio portfolio) {
		ResponsePortfolio responsePortfolio = new ResponsePortfolio();
		try {
			GetConnection.getInstance().getJdbcTemplate().update(QueryPortfolio.getInstance().getInsertToPotfolio(),portfolio.getUsername(),portfolio.getUserType(),portfolio.getNameCoin(),portfolio.getPriceInitial(),portfolio.getPriceCurrent(),portfolio.getQuantity());
			return new PortofolioResponseStatus().succes(responsePortfolio, null, null);
		} catch (Exception e) {
			return new PortofolioResponseStatus().error(responsePortfolio,e);
		}

	}
}
