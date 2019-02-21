package global.sesoc.web6.vo;

public class ReplyCountVO {
	private int boardnum;
	private int repcnt;

	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public int getRepcnt() {
		return repcnt;
	}
	public void setRepcnt(int repcnt) {
		this.repcnt = repcnt;
	}
	public ReplyCountVO(int boardnum, int repcnt) {
		super();
		this.boardnum = boardnum;
		this.repcnt = repcnt;
	}
	public ReplyCountVO() {
		super();
	}
	@Override
	public String toString() {
		return "ReplyCountVO [boardnum=" + boardnum + ", repcnt=" + repcnt + "]";
	}

}
