package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.Message;

public class MessageMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int index) throws SQLException {
		Message message = new Message();
		
		message.setMessage(rs.getString(1));
		return message;
	}

}
