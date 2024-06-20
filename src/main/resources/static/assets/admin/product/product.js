app.controller("product-ctrl", function ($scope, $http) {
    //alert("product")
    $scope.itemsProduct = [];
    $scope.formProduct = [];

    $scope.shoeType = [];
    $scope.brand = [];
    $scope.size = [];
    $scope.style = [];
    $scope.color = [];
    $scope.shoeSole = [];
    $scope.material = [];
    $scope.dmproduct = [];
	$scope.discount = [];

    $scope.itemsImagePr = []
    $scope.formImagePr = [];

    var productDetailId;
    $scope.initialize = function () {
        //load product
        $http.get("/rest/productsDetail").then(resp => {
            $scope.itemsProduct = resp.data;
            $scope.itemsProduct.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
            $scope.reset();
        })
        //load shole_type
        $http.get("/rest/shoeType/getAllStatus").then(resp => {
            $scope.shoeType = resp.data;
        })
        
        //load discount
        $http.get("/rest/discount/statusTrue").then(resp => {
            $scope.discount = resp.data;
        })
        
        //load product
        $http.get("/rest/products").then(resp => {
            $scope.dmproduct = resp.data;
        })
        //load Brand
        /*$http.get("/rest/brand/getAllStatus").then(resp => {
            $scope.brand = resp.data;
        })*/
       /* $http.get(`/rest/ImageProduct`).then(resp => { 
            $scope.itemsImagePr = resp.data;
        })*/
        
        //load size
        $http.get("/rest/size/getAllStatus").then(resp => {
            $scope.size = resp.data;
        })
        
        //load style
        $http.get("/rest/style/getAllStatus").then(resp => {
            $scope.style = resp.data;
        })
        
        //load color
        $http.get("/rest/color/getAllStatus").then(resp => {
            $scope.color = resp.data;
        })
        //load sole
        $http.get("/rest/shoeSole/getAllStatus").then(resp => {
            $scope.shoeSole = resp.data;
        })
        
        //load material
        $http.get("/rest/material/getAllStatus").then(resp => {
            $scope.material = resp.data;
        })
        productDetailId = "";
    }
    //khởi đầu
    $scope.initialize();
$scope.reset1 = function () {
		//alert("reset")
		$scope.form = {
			status: true,
		
		}
	}
	$scope.reset1 = function () {
        //alert("Xóa Form")
        $("#image").val("");
        $scope.formProduct = {
            status: true,
        }
        $scope.formImagePr = {
            images: 'cloud-upload.jpg',
        }
    }
    //Thêm mới
    $scope.create = function () { 
        //alert("Create")
        var item = angular.copy($scope.formProduct);
        item.createDate = item.createDate; 
        
        /*var productName = document.getElementById("productName").value;
		if(productName.trim() =="" || productName ==null){
			alert("Tên sản phẩm không được để trống");
			return false;
		}*/
		var productSelect = document.getElementById("productSelect").value;
		if(productSelect =="" || productSelect ==null){
			alert("Mã code sản phẩm không được để trống");
			return false;
		}
		
		var shoeTypeIdSelect = document.getElementById("shoeTypeIdSelect").value;
		if(shoeTypeIdSelect =="" || shoeTypeIdSelect ==null){
			alert("Loại giày không được để trống");
			return false;
		}
		
		var sizeSelect = document.getElementById("sizeSelect").value;
		if(sizeSelect =="" || sizeSelect ==null){
			alert("Size không được để trống");
			return false;
		}
		var styleSelect = document.getElementById("styleSelect").value;
		if(styleSelect =="" || styleSelect ==null){
			alert("Phong cách không được để trống");
			return false;
		}
		var colorSelect = document.getElementById("colorSelect").value;
		if(colorSelect =="" || colorSelect ==null){
			alert("Màu sắc không được để trống");
			return false;
		}
		
		var shoeSoleSelect = document.getElementById("shoeSoleSelect").value;
		if(shoeSoleSelect =="" || shoeSoleSelect ==null){
			alert("Đế giày không được để trống");
			return false;
		}
		
		var materialSelect = document.getElementById("materialSelect").value;
		if(materialSelect =="" || materialSelect ==null){
			alert("Chất liệu không được để trống");
			return false;
		}
		var productPrice = document.getElementById("productPrice").value;
		if(productPrice =="" || productPrice ==null){
			alert("Giá sản phẩm không được để trống");
			return false;
		}
		var productQuantity = document.getElementById("productQuantity").value;
		if(productQuantity =="" || productQuantity ==null){
			alert("Số lượng sản phẩm không được để trống");
			return false;
		} 
		
        /*$http.post(`/rest/productsDetail/checkName`, item).then(resp => {
            if(resp.data !=null && resp.data !=""){
				alert("Mã sản phẩn đã tồn tại");
				return false;
			}else{*/
				$http.post(`/rest/productsDetail`, item).then(resp => {
	            resp.data.createDate = new Date(resp.data.crateDate)
	            $scope.itemsProduct.push(resp.data);
	            //$scope.reset();
	            $scope.initialize();
	            alert("Thêm mới sản phẩm thành công!");
	            $(".nav-tabs a:eq(0)").tab('show')
		        }).catch(error => {
		            alert("Thêm mới thất bại");
		            console.log(error);
		        });
			/*}
        }).catch(error => {
            alert("Thêm mới thất bại");
            console.log(error);
        });*/
        
    }
    //cập nhật sp
    $scope.update = function () {
        //alert("update sp")
        var item = angular.copy($scope.formProduct);
        item.crateDate = item.createDate;
        //alert("id " + item.productDetailId +" "+ "crateDate " + item.crateDate);
        
        
        var productSelect = document.getElementById("productSelect").value;
		if(productSelect =="" || productSelect ==null){
			alert("Mã code sản phẩm không được để trống");
			return false;
		}
		
		var shoeTypeIdSelect = document.getElementById("shoeTypeIdSelect").value;
		if(shoeTypeIdSelect =="" || shoeTypeIdSelect ==null){
			alert("Loại giày không được để trống");
			return false;
		}
		
		var sizeSelect = document.getElementById("sizeSelect").value;
		if(sizeSelect =="" || sizeSelect ==null){
			alert("Size không được để trống");
			return false;
		}
		var styleSelect = document.getElementById("styleSelect").value;
		if(styleSelect =="" || styleSelect ==null){
			alert("Phong cách không được để trống");
			return false;
		}
		var colorSelect = document.getElementById("colorSelect").value;
		if(colorSelect =="" || colorSelect ==null){
			alert("Màu sắc không được để trống");
			return false;
		}
		
		var shoeSoleSelect = document.getElementById("shoeSoleSelect").value;
		if(shoeSoleSelect =="" || shoeSoleSelect ==null){
			alert("Đế giày không được để trống");
			return false;
		}
		
		var materialSelect = document.getElementById("materialSelect").value;
		if(materialSelect =="" || materialSelect ==null){
			alert("Chất liệu không được để trống");
			return false;
		}
		var productPrice = document.getElementById("productPrice").value;
		if(productPrice =="" || productPrice ==null){
			alert("Giá sản phẩm không được để trống");
			return false;
		}
		var productQuantity = document.getElementById("productQuantity").value;
		if(productQuantity =="" || productQuantity ==null){
			alert("Số lượng sản phẩm không được để trống");
			return false;
		}
		 
       /* $http.post(`/rest/productsDetail/checkName`, item).then(resp => { 
			 if(resp.data !=null && resp.data !="" && resp.data.name !='' && nameCheck!=resp.data.name){ 
				alert("Mã sản phẩn đã tồn tại");
				return false;
			}else{*/
				$http.put(`/rest/productsDetail/${item.productDetailId}`, item).then(resp => {
	            var index = $scope.itemsProduct.findIndex(p => p.productDetailId == item.productDetailId);
	            $scope.itemsProduct[index] = item;
	            alert("Cập nhật thành công");
	            $scope.initialize();
	            $(".nav-tabs a:eq(0)").tab('show');
        }).catch(error => {
            alert("Xảy ra lỗi trong quá trình cập nhật " + error)
            console.log(error);
        })
			/*}*/
		/*}).catch(error => {
            alert("Xảy ra lỗi trong quá trình cập nhật ");
            console.log(error);
        });;*/
    }
    //xóa sp
    $scope.delete = function (item) {
        //alert("delete sp" + item.productDetailId)
        var t = confirm("Bạn muốn xóa");
        if (t == false) {
            //alert("Không Xóa");
        } else {
            //alert("có xóa");
            /*$http.delete(`/rest/productsDetail/${item.productDetailId}`).then(resp => {
                var index = $scope.itemsProduct.findIndex(p => p.productDetailId == item.productDetailId);
                $scope.itemsProduct.splice(index, 1);
                $scope.reset();
                alert("Xóa Thành Công");
            }).catch(error => {
                alert("Lỗi xóa!")
                console.log("Error", error);
            })*/
            $http.put(`/rest/productsDetail/delete/${item.productDetailId}`, item).then(resp => {
	            var index = $scope.itemsProduct.findIndex(p => p.productDetailId == item.productDetailId);
	            $scope.itemsProduct[index] = item;
	            alert("Xóa sp thành công");
	            $scope.initialize();
		        }).catch(error => {
		            alert("Lỗi Xóa Sp" + error)
		            console.log(error);
		        })
            
        }

    }
    
    $scope.formatSoNguyenDuong = function (value,obj) {
    var strvalue;
    strvalue = value;
    var str = strvalue.split('.');
    var num;
    var val = strvalue;
    strvalue = '';
    for (var i = 0; i < val.length; i++) {
        strvalue += $scope.getVal(val.charAt(i));
    }
    num = strvalue.toString().replace(/\$|\./g, '');
    if (num.length > 15) num = num.substring(0, 15);
    if (!$scope.IsNumeric(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    num = Math.floor(num / 100).toString();
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3))  +
        num.substring(num.length - (4 * i + 3));
    //return (((sign)?'':'-') + num);
   	value = (((sign) ? '' : '-') + num);
   	if(obj =="gia"){
		  $scope.formProduct.price = value;
	  }
	  
	  if(obj =="sl"){
		  $scope.formProduct.quantity = value;
	  }
	  
}

 $scope.allowPressNeg = function(value) {
    var dsChar = '-';
    if (value.indexOf(dsChar) >= 0) {
        if ((event.keyCode < 48 && event.keyCode != 9) || event.keyCode > 57) event.returnValue = false;
    } else {
        if ((event.keyCode < 48 && event.keyCode != 9 && event.keyCode != 45) || event.keyCode > 57) event.returnValue = false;
    }
}

 $scope.formatSoNguyenDuongMaxLength = function(value,maxLength) {
    var strvalue;
    strvalue = value;
    var strvalue2 = strvalue.replace(/\./g, '');
    if(strvalue2.length > maxLength){
    	strvalue = strvalue2.substr(0,maxLength);
    }
    var str = strvalue.split('.');
    var num;
    var val = strvalue;
    strvalue = '';
    for (var i = 0; i < val.length; i++) {
        strvalue += getVal(val.charAt(i));
    }
    num = strvalue.toString().replace(/\$|\./g, '');
    if (num.length > 15) num = num.substring(0, 15);
    if (!IsNumeric(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    num = Math.floor(num / 100).toString();
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + '.' +
        num.substring(num.length - (4 * i + 3));
    //return (((sign)?'':'-') + num);
    eval(obj).value = (((sign) ? '' : '-') + num);
}

$scope.IsNumeric = function(sText) {
	var ValidChars = "0123456789.,-";
	var IsNumber = true;
	var Char;

	for (var i = 0; i < sText.length && IsNumber == true; i++) {
		Char = sText.charAt(i);
		if (ValidChars.indexOf(Char) == -1) {
			IsNumber = false;
			break;
		}
	}
	return IsNumber;
}

 $scope.getVal = function(num){
	if(num==''|| $scope.checkNumeric(num)){
	    return '';
	}else{
	    return (num);
	}
}

 $scope.checkNumeric = function(sText)
{
    var ValidChars = "0123456789";
    var IsNumber=true;
    if (ValidChars.indexOf(sText) != -1)
      {
        IsNumber = false;
      }
    return IsNumber;
}

    //upload hình
    $scope.imageChanged = function (files) { 
        //alert("hìn")
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.formProduct.image = resp.data.name;
            $scope.formImagePr.images = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình" + error);
            console.log("Error", error);
        })
    }

    //xóa form
    $scope.reset = function () {
        //alert("Xóa Form")
        $("#image").val("");
        $scope.formProduct = {
			productDetailId: $scope.formProduct.productDetailId,
            createDate: new Date(),
            image: 'cloud-upload.jpg',
            status: true,
        }
        $scope.formImagePr = {
            images: 'cloud-upload.jpg',
        }
    }
    ///tìm kiếm
    $scope.timKiem = function () {
        var name = document.getElementById("keyword").value;
        var trangThai = document.getElementById("trangThai").value;
        if (trangThai == "") {
            trangThai = null;
            //alert("Tìm Kiếm: " + name + " trang thai= " + trangThai)
            $http.get(`/rest/productsDetail/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.itemsProduct = resp.data;
            })
        } else {
            $http.get(`/rest/productsDetail/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.itemsProduct = resp.data;
            })
        }
       
    }
    $scope.genderStart = function (obj) {
        var trangThai = document.getElementById("trangThai").value;
        //alert("Trang thái " + trangThai )
        if (trangThai == "") {
            $http.get("/rest/productsDetail").then(resp => {
                $scope.itemsProduct = resp.data;
            })
        } else {
            $http.get(`/rest/productsDetail/timKiem/${trangThai}`).then(resp => {
                $scope.itemsProduct = resp.data;
            })
        }

    }

    //imageProduct
    //hiện lên form product
    var nameCheck="";
    $scope.edit = function (item) { 
        $scope.formProduct = angular.copy(item);
        //$scope.formProduct.createDate = $filter('date')(item.createDate, "dd/MM/yyyy");
        $(".nav-tabs a:eq(1)").tab('show');
        nameCheck = $scope.formProduct.name;
        $("#image").val("");
    }
    //hiện image
    $scope.editImage = function (item) {
        alert("Thêm ảnh chi tiết mã " + item.name)
        console.log(item)
        $scope.formImagePr = {
            images: item.image,
        }
        $scope.formImagePr.product = {
            productDetailId: item.productDetailId,
        }
        productDetailId = item.productDetailId;
        $scope.tableImage(item.productDetailId);
        $(".nav-tabs a:eq(2)").tab('show')
    }

    $scope.image = function (item) {
        // alert("product " + item.product.productDetailId)
        $("#bt1").attr("disabled", true);
        console.log(item)
        $scope.formImagePr = angular.copy(item);
        $scope.tableImage(item.product.productDetailId);
        $(".nav-tabs a:eq(2)").tab('show')
    }

   
    $scope.genderChanged = function () {
        productDetailId = $scope.formImagePr.product.productDetailId;
        if (productDetailId == "") {
            //alert("chọn tất cả ")
            $http.get(`/rest/ImageProduct`).then(resp => { 
                $scope.itemsImagePr = resp.data;
            })
            productDetailId = "";
        } else { 
            //alert("genderChanged " + productDetailId)
            productDetailId = $scope.formImagePr.product.productDetailId;
            $scope.tableImage(productDetailId);
            $scope.pagerImage();

        }
    }

    $scope.tableImage = function (id) { 
        $http.get(`/rest/ImageProduct/${id}`).then(resp => {
            $scope.itemsImagePr = resp.data;
        })
    }


    //Thêm mới ảnh
    $scope.createImage = function () { 
        //$scope.formImagePr.image = resp.data.name;
        var item = angular.copy($scope.formImagePr);
        item.imageId = "";
        if (productDetailId == "") {
            alert("Chưa chọn sp")
        } else {
            //alert("Thêm Mới Anh cho SP " + item.product.productDetailId)
            console.log(item)
            $http.post(`/rest/ImageProduct`, item).then(resp => { 
                $scope.itemsImagePr.push(resp.data);
                //$scope.reset();
                $scope.tableImage(productDetailId);
                alert("Thêm mới ảnh thành công!");
            }).catch(error => {
                alert("Thêm mới ảnh thất bại");
                console.log(error);
            });
        }
    }
    //cập nhật anh
    $scope.updateImage = function () {
        //alert("updateImage")
        var item = angular.copy($scope.formImagePr);
        $http.put(`/rest/ImageProduct/${item.imageId}`, item).then(resp => { 
            var index = $scope.itemsImagePr.findIndex(p => p.imageId == item.imageId);
            $scope.itemsImagePr[index] = item;
            alert("Cập nhật thành công");
            $("#bt1").attr("disabled", false);
        }).catch(error => {
            alert("Xảy ra lỗi trong quá trình cập nhật " + error)
            console.log(error);
        })
    }
    //xóa ảnh
    $scope.deleteImage = function (item) {
        //alert("delete Iamge" + item.imageId)
        $http.delete(`/rest/ImageProduct/${item.imageId}`).then(resp => {debugger
            var index = $scope.itemsImagePr.findIndex(p => p.imageId == item.imageId);
            $scope.itemsImagePr.splice(index, 1);

            $scope.formImagePr = {
                images: 'cloud-upload.jpg',
                product: $scope.formImagePr.product,
            }
            $("#image").val("");
            alert("Xóa Thành Công");
        })
            .catch(error => {
                alert("Lỗi xóa!")
                console.log("Error", error);
            })
    }


    //phân trang product
    $scope.pager = {
        page: 0,
        size: 10,
        get itemsProduct() {
            var start = this.page * this.size;
            return $scope.itemsProduct.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.itemsProduct.length / this.size);
        },

        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;

        }
    }

    ///phân trang image
    $scope.pagerImage = {
        page: 0,
        sizeImage: 4,
        get itemsImagePr() { 
            var start = this.page * this.sizeImage;
            return $scope.itemsImagePr.slice(start, start + this.sizeImage);
        },
        get countImage() {
            return Math.ceil(1.0 * $scope.itemsImagePr.length / this.sizeImage);
        },

        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.countImage) {
                this.first();
            }
        },
        last() {
            this.page = this.countImage - 1;

        }

    }

})