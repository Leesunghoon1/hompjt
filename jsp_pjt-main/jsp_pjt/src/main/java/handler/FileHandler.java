package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static final Logger log = 
			LoggerFactory.getLogger(FileHandler.class);
	//이 코드는 LoggerFactory를 사용하여 로그를 기록하는 log 객체를 정의합니다
	
	//파일 이름과 경로를 받아서 파일을 삭제하는 메서드
	//리턴타입 int(isOk) => 잘 삭제했는지 체크하기 위한 변수
	public int deleteFile(String imageFileName, String savePath) {
		//deleteFile 메서드는 두 개의 매개변수를 받습니다. 
		//imageFileName은 삭제할 파일의 이름이고, savePath는 파일이 저장된 경로를 나타냅니다.
		boolean isDel = true; //삭제가 잘 이루어졌는지 체크하는 변수
		//isDel 변수는 파일 삭제 작업의 성공 여부를 나타내는 불리언 변수입니다. 처음에는 true로 초기화됩니다.
		log.info("imageFileName >> "+ imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThFile = new File(fileDir+File.separator+"_th_"+imageFileName);
		//File 클래스를 사용하여 파일과 디렉토리를 다루기 위한 객체를 생성합니다.
		//fileDir 변수는 삭제 대상 파일이 저장된 디렉토리를 가리킵니다.
		//removeFile 변수는 삭제할 파일을 가리킵니다.
		//removeThFile 변수는 삭제할 썸네일 파일을 가리킵니다.
		
		//현재 시점에서 삭제하고자 하는 파일이 있어야(존재해야) 삭제
		if(removeFile.exists() || removeThFile.exists()) {
			//removeFile.delete()를 호출하여 파일 삭제를 시도하고, 그 결과를 isDel 변수에 저장합니다. 
			//파일 삭제 작업의 결과는 boolean 형태로 반환됩니다. 삭제가 성공하면 true가 되고, 
			//그렇지 않으면 false가 됩니다. 로그에는 삭제 결과가 출력됩니다.
			//if 문을 사용하여 삭제할 파일 또는 썸네일 파일이 현재 시점에서 존재하는지 확인합니다.
			isDel = removeFile.delete(); //boolean 형태로 리턴
			log.info(">>>>> del : "+(isDel?"OK":"File"));
			if(isDel) {
				//기존 파일 삭제 작업이 성공한 경우, isDel 변수를 사용하여 썸네일 파일 삭제를 시도합니다. 마찬가지로 삭제 결과가 로그에 출력됩니다.
				isDel = removeThFile.delete();
				log.info(">>>>> thFile del : "+(isDel?"OK":"File"));
			}
		}
		log.info("remove File Ok");
		
		return isDel ? 1: 0;
		//isDel 변수가 true이면 1을 반환하고, 그렇지 않으면 0을 반환하여 삭제 작업의 성공 여부를 나타냅니다. 이 값은 삭제 작업의 결과를 호출자에게 반환합니다.
		
	}
}
