app.controller("sole-ctrl", function ($scope, $http) {
	//alert("sole-ctrl")
	$scope.items = [];
	$scope.form = [];
	$scope.cates = [];

	var check ;
	$scope.initialize = function () {
		//load product
		$http.get("/rest/shoeSole").then(resp => {
			$scope.items = resp.data;
			$scope.reset();
		})

	}
	//khởi đầu
	$scope.initialize();
	//xóa form
	$scope.reset = function () {
		//alert("reset")
		$scope.form = {
			shoeSoleId: $scope.form.shoeSoleId,
			status: true,
			image: 'cloud-upload.jpg',
		}
	}
	$scope.reset1 = function () {
		//alert("reset")
		$scope.form = {
			status: true,
		
		}
	}
	//hiện lên form
	$scope.edit = function (item) {
		//alert("edit")
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(1)").tab('show')
	}

	$///tìm kiếm
    $scope.timKiem = function () {
        var name = document.getElementById("keyword").value;
        var trangThai = document.getElementById("trangThai").value;
        if (trangThai == "") {
            trangThai = null;
            //alert("Tìm Kiếm: " + name + " trang thai= " + trangThai)
            $http.get(`/rest/shoeSole/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        } else {
            $http.get(`/rest/shoeSole/timKiem/${name}/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        }
       
    }
    $scope.genderStart = function (obj) {
        var trangThai = document.getElementById("trangThai").value;
        //alert("Trang thái " + trangThai )
        if (trangThai == "") {
            $http.get("/rest/shoeSole").then(resp => {
                $scope.items = resp.data;
            })
        } else {
            $http.get(`/rest/shoeSole/timKiem/${trangThai}`).then(resp => {
                $scope.items = resp.data;
            })
        }

    }
    
	//Thêm mới
	$scope.create = function () {
		//alert("Create ")
		var item = angular.copy($scope.form);
		//alert("Tên Thương Hiệu " + item.name)
		
		var soleName = document.getElementById("soleName").value;
		if(soleName.trim() =="" || soleName ==null){
			alert("Tên chống nước không được để trống");
			return false;
		}
		
		$http.get(`/rest/shoeSole/${item.name}`).then(resp =>{
			if (resp.data == '') {
				//alert("Thương hiệu mới")
				$http.post(`/rest/shoeSole`, item).then(resp => {
					$scope.items.push(resp.data);
					$scope.initialize();
					alert("Thêm mới thành công!");
					$(".nav-tabs a:eq(0)").tab('show')
				}).catch(error => {
					alert("Thêm mới thất bại");
					console.log(error);
				});
			} else {
				alert("Đã có độ chống nước này")
				console.log(resp.data)
			}
		})		


	}

	//cập nhật 
	$scope.update = function () {
		//alert("update ")
		var item = angular.copy($scope.form);
		//alert("shoeSoleId " + item.discountId); 
		var soleName = document.getElementById("soleName").value;
		if(soleName.trim() =="" || soleName ==null){
			alert("Tên chống nước không được để trống");
			return false;
		}
		
		$http.put(`/rest/shoeSole/${item.shoeSoleId}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.shoeSoleId == item.shoeSoleId);
			$scope.items[index] = item;
			alert("Cập nhật thành công");
			$(".nav-tabs a:eq(0)").tab('show')
		}).catch(error => {
			alert("Xảy ra lỗi trong quá trình cập nhật " + error)
			console.log("error", error);
		})
	}
	//xóa 
	$scope.delete = function (item) {
		//alert("delete")
		var t = confirm("Bạn muốn xóa");
		if (t == false) {
			//alert("Không Xóa");
		} else {
			//alert("có xóa");
			/*$http.delete(`/rest/shoeSole/${item.shoeSoleId}`).then(resp => {
				var index = $scope.items.findIndex(p => p.shoeSoleId == item.shoeSoleId);
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("Xóa Thành Công");
			})
				.catch(error => {
					alert("Lỗi xóa!")
					console.log("Error", error);
				})*/
			$http.put(`/rest/shoeSole/delete/${item.shoeSoleId}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.shoeSoleId == item.shoeSoleId);
				$scope.items[index] = item;
				alert("xóa sole thành công");
				$scope.initialize();
			}).catch(error => {
				alert("Lỗi xóa sole" + error)
				console.log("error", error);
			})	
			

		}
	}

	$scope.check = function (name){
		$http.get(`/rest/shoeSole/${name}`).then(resp =>{
			if (resp.data == '') {
				//alert("Không tìm thấy  " + name)
				check = true;
			} else {
				//alert("Tìm thấy  " + name)
				check = false;
				console.log(resp.data)
			}
		})
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
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình" + error);
			console.log("Error", error);
		})
	}


	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count - 1;
		}
	}
});