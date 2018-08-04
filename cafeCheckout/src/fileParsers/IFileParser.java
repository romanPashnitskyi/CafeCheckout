package fileParsers;

import java.util.List;

import models.OrderLine;

public interface IFileParser {
	List<OrderLine> parse();
}
