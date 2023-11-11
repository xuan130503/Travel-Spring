package Travel_Foly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/travelfpoly/admin/scanner/")
public class ScannerController {
	 @GetMapping("scan")
	    public String showScanPage() {
        return "admin/Scanner";
    }

    @PostMapping("processBarcode")
    public String processBarcode(@RequestParam("barcodeData") String barcodeData) {
        // Xử lý dữ liệu mã vạch ở đây
        return  barcodeData;
    }
}
