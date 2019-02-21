package global.sesoc.web6.vo;

public class BoardVO {
	private int boardnum;
	private String id;
	private String title;
	private String custid;
	private String content;
	private String inputdate;
	private int hits;
	private int repcnt;
	private String originalfile;		//원래 저장 이름	
	private String savedfile;			//실제 저장 이름
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getRepcnt() {
		return repcnt;
	}
	public void setRepcnt(int repcnt) {
		this.repcnt = repcnt;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	public String getSavedfile() {
		return savedfile;
	}
	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}
	public BoardVO(int boardnum, String id, String title, String custid, String content, String inputdate, int hits,
			int repcnt, String originalfile, String savedfile) {
		super();
		this.boardnum = boardnum;
		this.id = id;
		this.title = title;
		this.custid = custid;
		this.content = content;
		this.inputdate = inputdate;
		this.hits = hits;
		this.repcnt = repcnt;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
	}
	public BoardVO() {
		super();
	}
	@Override
	public String toString() {
		return "BoardVO [boardnum=" + boardnum + ", id=" + id + ", title=" + title + ", custid=" + custid + ", content="
				+ content + ", inputdate=" + inputdate + ", hits=" + hits + ", repcnt=" + repcnt + ", originalfile="
				+ originalfile + ", savedfile=" + savedfile + "]";
	}
	


}
