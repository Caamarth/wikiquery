package wikipedia.event.client;

/*-
 * #%L
 * wikipedia-event-query
 * %%
 * Copyright (C) 2017 Debreceni Egyetem, Informatikai Kar
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import wikipedia.event.model.Event;
import wikipedia.event.parser.EventExtractor;

/**
 * Command line client for querying events that occurred on a specific day of month.
 */
public class CmdLineClient {

	private static void printHelpAndExit() {
		System.err.printf("Usage: java %s <month> <day>\n", CmdLineClient.class.getName());
		System.exit(1);
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			printHelpAndExit();
		}
		try {
			int month = Integer.parseInt(args[0]);
			int day = Integer.parseInt(args[1]);
			for (Event event : new EventExtractor().getEvents(month, day)) {
				System.out.println(event);
			}
		} catch(NumberFormatException e) {
			System.err.println("Invalid argument");
			printHelpAndExit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
